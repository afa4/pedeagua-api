package br.com.pedeagua.api.entity

import br.com.pedeagua.api.dao.Distributors
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Distributor(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Distributor>(Distributors)

    var name by Distributors.name
    var cnpj by Distributors.cnpj
    var email by Distributors.email
    var user by User referencedOn Distributors.user
    var address by Address referencedOn Distributors.address
}