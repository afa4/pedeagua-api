package br.com.pedeagua.api.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object Addresses: LongIdTable() {
    val street = Distributor.varchar("street", 100)
    val number = Distributor.varchar("number", 50)
    val zipCode = Distributor.varchar("zipcode", 50)
    val district = Distributor.varchar("district", 100)
}
