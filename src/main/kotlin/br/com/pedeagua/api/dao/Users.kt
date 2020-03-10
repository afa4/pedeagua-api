package br.com.pedeagua.api.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object Users : LongIdTable() {
    val uid = uuid("uid").autoGenerate().uniqueIndex()
    val username = varchar("username", 100)
    val password = varchar("password", 100)
}