package com.example.contactbook.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Accounts")
data class Accounts(
    val status: Int,
    val userId: String,
    @PrimaryKey
    val _context: String)