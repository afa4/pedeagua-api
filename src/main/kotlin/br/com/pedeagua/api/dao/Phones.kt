package br.com.pedeagua.api.dao

import org.jetbrains.exposed.sql.Table


object Phones: Table() {
    val number = varchar("number", 20).uniqueIndex()
    val user = reference("user", Users)
}