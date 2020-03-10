package br.com.pedeagua.api.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object Addresses : LongIdTable() {
    val street = Distributors.varchar("street", 100)
    val number = Distributors.varchar("number", 50)
    val zipCode = Distributors.varchar("zip_code", 50)
    val neighbourhood = Distributors.varchar("neighbourhood", 100)
    val complement = Distributors.varchar("complement", 100).nullable()
}
