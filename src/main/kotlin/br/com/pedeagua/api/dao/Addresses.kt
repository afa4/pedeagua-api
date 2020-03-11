package br.com.pedeagua.api.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object Addresses : LongIdTable() {
    val street = varchar("street", 100)
    val number = varchar("number", 50)
    val zipCode = varchar("zip_code", 50)
    val neighbourhood = varchar("neighbourhood", 100)
    val complement =  varchar("complement", 100).nullable()
}
