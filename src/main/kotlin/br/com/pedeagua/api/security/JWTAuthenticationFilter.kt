package br.com.pedeagua.api.security

import br.com.pedeagua.api.security.models.Credentials
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(authenticationManager: AuthenticationManager, private var jwtUtil: JWTUtil) : UsernamePasswordAuthenticationFilter() {

    init {
        this.authenticationManager = authenticationManager
        setFilterProcessesUrl("/login")
    }

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication? {
        try {
            val credentials = ObjectMapper().readValue(request.reader, Credentials::class.java)
            val token = UsernamePasswordAuthenticationToken(credentials.username, credentials.password)
            return authenticationManager.authenticate(token)
        } catch (e: Exception) {
            throw UsernameNotFoundException("")
        }
    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse, chain: FilterChain?, authResult: Authentication) {
        val username = (authResult.principal as UserDetailsImpl).username
        val token = jwtUtil.generateToken(username)
        response.addHeader("Authorization", "Bearer $token")
    }
}

