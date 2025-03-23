package com.example.pfe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class securityConfig  {

    @Value("${spring.security.oauth2.client.provider.keycloak.jwk-set-uri}")
    private String jwkSetUri;

    @Bean
    public JwtDecoder decode() {
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }


    @Bean
    public KeycloakConverter customKeycloakConverter()
    {
        return new KeycloakConverter();
    }
    @Bean
    public JwtAuthenticationProvider jwtAuthenticationProvider()
    {
        return new JwtAuthenticationProvider(decode());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.OPTIONS, "/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/projet/getAllusers")).permitAll()
                        // hasAuthority yaani l accees keen l admin
                        //.requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/projet/getAllusers")).hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        // decode les tokens JWT pour authentifier les users
                        // estaaml decode pour decoder les tokens w baad aaml convertion ll token hedheka a des attributs fl customkeycloakconverter
                        .jwt(jwt -> jwt.decoder(decode()).jwtAuthenticationConverter(customKeycloakConverter())));

        return http.build();
    }
}
