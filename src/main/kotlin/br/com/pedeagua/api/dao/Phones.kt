package br.com.pedeagua.api.dao

import org.jetbrains.exposed.sql.Table


object Phones : Table() {
    val ddd = varchar("ddd", 20)
    val number = varchar("number", 20)
    val user = reference("user", Users)
    override val primaryKey = PrimaryKey(ddd, number)
}