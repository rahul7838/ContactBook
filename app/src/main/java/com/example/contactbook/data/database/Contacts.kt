package com.example.contactbook.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contacts(
    @PrimaryKey
    val _id: Int,
    val contactId: String,
    val stagingId: String)