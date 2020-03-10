package br.com.pedeagua.api.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object Addresses : LongIdTable() {
    val street = Distributor.varchar("street", 100)
    val number = Distributor.varchar("number", 50)
    val zipCode = Distributor.varchar("zip_code", 50)
    val neighbourhood = Distributor.varchar("neighbourhood", 100)
    val complement = Distributor.varchar("complement", 100).nullable()
}
