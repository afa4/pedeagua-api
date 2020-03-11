package br.com.pedeagua.api.security

import br.com.pedeagua.api.dao.Users
import br.com.pedeagua.api.entity.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class UserDetailsServiceImpl : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = User.find { Users.username eq username!! }.firstOrNull()

        return UserDetailsImpl(user!!)
    }

}