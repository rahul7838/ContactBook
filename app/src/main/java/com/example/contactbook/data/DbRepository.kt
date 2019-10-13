package com.example.contactbook.data

import android.app.Activity
import android.content.Context
import com.example.contactbook.data.database.Contacts
import com.example.contactbook.data.database.ContactsDatabase
import com.example.contactbook.data.database.MockDataProvider
import com.example.contactbook.data.model.ContactDetails
import java.util.concurrent.Executors

class DbRepository(context: Context) {

    private val diskIoExecutor = Executors.newSingleThreadExecutor()
//    private val networkIoExecutor = Executors.newFixedThreadPool(1)

    private val db by lazy {
        ContactsDatabase.invoke(context)
    }

    fun insertData() {
        diskIoExecutor.execute {
            db.runInTransaction {
                db.getContactsDao().insertContact(MockDataProvider.getListOfContacts())
                db.getContactsDao().insertExtension(MockDataProvider.getListOfExtensions())
                db.getContactsDao().insertAccount(MockDataProvider.getListOfAccounts())

            }
        }
    }

    fun getListOfContactId(job: (list: ArrayList<String>)-> Unit, activity: Activity) {
        diskIoExecutor.execute {
            db.runInTransaction {
                val list = db.getContactsDao().getContactId()
                activity.runOnUiThread {job.invoke(list as ArrayList<String>) }
            }
        }
    }

    fun getDetailsOfContactId(contactId: String, job: (contactDetails: ContactDetails)->Unit, activity: Activity) {
        diskIoExecutor.execute {
            db.runInTransaction {
                val contactDetails = db.getContactsDao().getContactIdDetails(contactId)
                activity.runOnUiThread {job.invoke(contactDetails) }
            }
        }
    }
}