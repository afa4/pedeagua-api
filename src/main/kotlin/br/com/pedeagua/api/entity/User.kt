package br.com.pedeagua.api.entity

import br.com.pedeagua.api.dao.Phones
import br.com.pedeagua.api.dao.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class User(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<User>(Users)

    var uid by Users.uid
    var username by Users.username
    var password by Users.password
    val phones by Phone referrersOn Phones.user
}