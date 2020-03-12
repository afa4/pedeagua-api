package br.com.pedeagua.api.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class JWTUtil {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    private val expiration: Long = 60000

    fun generateToken(username: String): String {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact()
    }

    private fun getSigningKey(): Key {
        val keyBytes = Decoders.BASE64.decode(secret)
        return Keys.hmacShaKeyFor(keyBytes)
    }

}