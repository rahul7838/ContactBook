package com.example.contactbook

import android.app.Application
import com.facebook.stetho.Stetho

class ContactBookApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}