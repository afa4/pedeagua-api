package br.com.pedeagua.api.entity

import br.com.pedeagua.api.dao.Addresses
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Address(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Address>(Addresses)

    var street by Addresses.street
    var number by Addresses.number
    var zipCode by Addresses.zipCode
    var neighbourhood by Addresses.neighbourhood
    var complement by Addresses.complement
}