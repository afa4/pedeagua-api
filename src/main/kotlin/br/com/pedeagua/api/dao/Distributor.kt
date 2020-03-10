package br.com.pedeagua.api.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object Distributor: LongIdTable() {
    val name = varchar("name", 100)
    val email = varchar("email", 100)
    val cnpj = varchar("cnpj", 100)
    val user = reference("user", Users)
    val address = reference("address", Addresses)
}