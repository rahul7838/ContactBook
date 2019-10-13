package com.example.contactbook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.contactbook.R
import com.example.contactbook.extensions.add
import com.example.contactbook.ui.contactdropdown.ContactDropDownFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add(ContactDropDownFragment.instance, R.id.container, false)
    }
}
