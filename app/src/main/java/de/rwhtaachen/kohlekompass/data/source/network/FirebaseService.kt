package de.rwhtaachen.kohlekompass.data.source.network

import com.google.firebase.database.*

class FirebaseService {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance("https://kohlekompass-default-rtdb.europe-west1.firebasedatabase.app/")
    private val transactionReference: DatabaseReference = database.reference.child("transactions")

    fun syncTransactions(transactions: List<Transaction>) {
        // Convert the list of transactions to a map where the transaction ID is the key
        val transactionMap = transactions.associateBy { it.id.toString() }

        // Replace the entire transaction node with the updated data
        transactionReference.setValue(transactionMap)
    }

    fun observeTransactions(listener: ValueEventListener) {
        transactionReference.addValueEventListener(listener)
    }
}
