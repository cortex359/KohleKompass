package de.rwhtaachen.kohlekompass.home

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.source.example.transactionList
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.manageTags.TagManager

class TransactionManager {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun addTransaction(transaction: Transaction) {
            transactionList.add(transaction)
            // todo
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun removeTransaction(transaction: Transaction) {
            transactionList.remove(transaction)
            // todo
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun updateTransaction(oldTransaction: Transaction, newTransaction: Transaction) {
            val transaction = transactionList[transactionList.indexOf(oldTransaction)]
            transaction.title = newTransaction.title
            transaction.user = newTransaction.user
            transaction.amount = newTransaction.amount
            transaction.value_date = newTransaction.value_date
            TagManager.getTagList().forEach { tag ->
                if (newTransaction.tags.any { tag.value.name == it.name }) {
                    transaction.tags.add(tag.value)
                } else {
                    transaction.tags.remove(tag.value)
                }
            }
        }

        /**
         * fetches the transactions from the database
         * todo
         */
        @RequiresApi(Build.VERSION_CODES.O)
        fun getTransactionList(): MutableList<MutableState<Transaction>> {
            // todo
            return transactionList.map { transaction -> mutableStateOf(transaction) }
                .toMutableStateList()
        }
    }
}

/**
 * The value returned by this is shown on the home screen in the bottom bar.
 * This could be e.g. the amount the current user is due to pay to the other users or something similar
 */
fun getAmountDue(): String {
    return "42.42€"
}