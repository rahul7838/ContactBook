package com.example.contactbook.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contactbook.data.model.ContactDetails

@Dao
interface ContactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(listOfContact: List<Contacts>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExtension(listOfExtensions: List<Extensions>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAccount(listOfAccounts: List<Accounts>)

    @Query("select contactId from Contacts")
    fun getContactId(): List<String>

    @Query("select contacts.stagingId, newTable._context, newTable.userId, " +
            "newTable.status from contacts join (select * from accounts join " +
            "extensions on extensions._context = accounts._context) as newTable " +
            "on contacts._id = newTable.phoneContactId " +
            "where contacts.contactId LIke :contactId")
    fun getContactIdDetails(contactId: String): ContactDetails



}