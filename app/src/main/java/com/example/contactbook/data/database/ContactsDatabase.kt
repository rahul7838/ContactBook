package com.example.contactbook.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Contacts::class, Accounts::class, Extensions::class],
    version = 1,
    exportSchema = false
)
abstract class ContactsDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: ContactsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            ContactsDatabase::class.java, "ContactsDb.db"
        )
            .build()
    }

    abstract fun getContactsDao(): ContactsDao

}