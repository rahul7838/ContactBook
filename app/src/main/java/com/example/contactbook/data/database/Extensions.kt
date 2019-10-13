package com.example.contactbook.data.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Extensions")
data class Extensions(
    @ForeignKey(
        entity = Accounts::class,
        parentColumns = ["_context"],
        childColumns = ["_context"]
    )
    val _context: String,
    @PrimaryKey
    @ForeignKey(
        entity = Contacts::class,
        parentColumns = ["_id"],
        childColumns = ["phoneContactId"])
    val phoneContactId: Int)