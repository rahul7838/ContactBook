package com.example.contactbook.ui.contactdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.contactbook.R
import com.example.contactbook.data.DbRepository
import com.example.contactbook.data.model.ContactDetails
import kotlinx.android.synthetic.main.contact_details_fragment.*

const val CONTACT_ID_KEY = "contact"

class ContactDetailsFragment : Fragment() {

    private lateinit var contact: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contact = arguments?.get(CONTACT_ID_KEY) as String
    }

    private fun updateUi(it: ContactDetails) {
        contactId.text = contact
        stagingId.text = it.stagingId
        _context.text = it._context
        userId.text = it.userId
        status.text = it.status.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return LayoutInflater.from(inflater.context).inflate(R.layout.contact_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DbRepository(requireContext()).getDetailsOfContactId(contact, {updateUi(it)}, requireActivity())
    }

    companion object {
        fun getInstance(contactId: String): ContactDetailsFragment {
            val fragment = ContactDetailsFragment()
            fragment.arguments = Bundle().apply {
                putString(CONTACT_ID_KEY, contactId)
            }
            return fragment
        }
    }

}