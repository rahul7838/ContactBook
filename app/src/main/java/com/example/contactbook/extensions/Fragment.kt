package com.example.contactbook.extensions

import androidx.fragment.app.Fragment

fun Fragment.replace(fragment: Fragment, resContainer: Int, isBackStack: Boolean = true, backStackName: String? = fragment::class.java.canonicalName) {
    activity?.supportFragmentManager?.beginTransaction().run {
        this?.replace(resContainer, fragment, backStackName)
        if(isBackStack) {
            this?.addToBackStack(backStackName)
        }
        this?.commit()
    }
}