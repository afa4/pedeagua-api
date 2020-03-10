package br.com.pedeagua.api.dao

import org.jetbrains.exposed.dao.id.LongIdTable


object Phones : LongIdTable() {
    val ddd = varchar("ddd", 20)
    val number = varchar("number", 20)
    val user = reference("user", Users)
}