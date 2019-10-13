package com.example.contactbook.data.database

class MockDataProvider {

    companion object {

        fun getListOfContacts(): ArrayList<Contacts> {

            val listOfContact = ArrayList<Contacts>()
            listOfContact.add(Contacts(2, "48f3", "1196"))
            listOfContact.add(Contacts(3, "3e47", "f1fe"))
            listOfContact.add(Contacts(4, "2cac", "036e"))

            return listOfContact
        }

        fun getListOfExtensions(): ArrayList<Extensions> {
            return arrayListOf<Extensions>(
                Extensions("Gmail", 2),
                Extensions("Gmail", 3),
                Extensions("Gmail1", 4)
            )
        }

        fun getListOfAccounts(): ArrayList<Accounts> {
            return arrayListOf(
                Accounts(1, "test_one@gmail.com", "Gmail"),
                Accounts(0, "test_two@gmail.com", "Gmail1")
            )
        }
    }
}