package com.example.contactbook

import android.app.Application
import android.content.Context
import com.example.contactbook.data.DbRepository

interface ServiceLocator {

    companion object {
        private val LOCK = Any()
        private var instance: ServiceLocator? = null
        fun instance(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: ServiceLocatorImpl(context).also { instance = it }
        }
    }

    fun getRepository(): DbRepository
}

open class ServiceLocatorImpl(private val context: Context) : ServiceLocator {

    override fun getRepository(): DbRepository {
        return DbRepository(context = context)
    }

}