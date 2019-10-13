package com.example.contactbook.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.add(
    fragment: Fragment,
    resContainer: Int,
    isBackStack: Boolean = true,
    backStackName: String? = fragment.javaClass.canonicalName
) {
    with(this.supportFragmentManager) {
        beginTransaction().run {
            add(resContainer, fragment, backStackName)
            if (isBackStack) {
                addToBackStack(backStackName)
            }
            commit()
        }
    }
}

