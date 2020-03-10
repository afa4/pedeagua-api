package br.com.pedeagua.api.entity

import br.com.pedeagua.api.dao.Phones
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Phone(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Phone>(Phones)

    var ddd by Phones.ddd
    var number by Phones.number
    var user by User referencedOn Phones.user
}