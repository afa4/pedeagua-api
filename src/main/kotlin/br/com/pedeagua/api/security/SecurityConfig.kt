package br.com.pedeagua.api.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig(val jwtUtil: JWTUtil, val objectMapper: ObjectMapper) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/v1/distributors").permitAll()
                .and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
        http.headers().frameOptions().disable()
        http.addFilter(JWTAuthenticationFilter(authenticationManager(), jwtUtil, objectMapper))
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    @Bean
    override fun userDetailsService(): UserDetailsService = UserDetailsServiceImpl()

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder())
    }

}
