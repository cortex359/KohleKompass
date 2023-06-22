package de.rwhtaachen.kohlekompass.home

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.source.example.transactionList
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.data.Money
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.data.User
import de.rwhtaachen.kohlekompass.manageTags.TagManager
import java.time.LocalDate

class TransactionManager {
    companion object {
        var sum = Money(42.21)

        @RequiresApi(Build.VERSION_CODES.O)
        fun addTransaction(transaction: Transaction) {
            transactionList.add(transaction)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun updateTransaction(oldTransaction: Transaction, newTransaction: Transaction) {
            val transaction = transactionList[transactionList.indexOf(oldTransaction)]
            transaction.title = newTransaction.title
            transaction.user = newTransaction.user
            transaction.amount = newTransaction.amount
            transaction.valueDate = newTransaction.valueDate
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
            return transactionList
                .sortedByDescending { it.valueDate }
                .map { transaction -> mutableStateOf(transaction) }
                .toMutableStateList()
        }

        /**
         * fetches the transactions from the database and filters them according to the given parameters
         */
        @RequiresApi(Build.VERSION_CODES.O)
        fun getFilteredTransactions(
            textQuery: String,
            startDate: LocalDate?,
            endDate: LocalDate?,
            tags: List<MutableState<Tag>>,
            users: List<MutableState<User>>
        ): MutableList<MutableState<Transaction>> {
            val filteredTransactions = getTransactionList().filter { transaction ->
                (textQuery.isEmpty()
                        || transaction.value.title.lowercase()
                    .contains(textQuery.lowercase())
                        || transaction.value.user.name.lowercase()
                    .contains(textQuery.lowercase()))
                        && (startDate == null || transaction.value.valueDate >= startDate)
                        && (endDate == null || transaction.value.valueDate <= endDate)
                        && (tags.all { tag -> !tag.value.selected } || tags.any { tag ->
                    tag.value.selected && transaction.value.tags.any { it.name == tag.value.name} // todo replace with id
                })
                        && (users.all { user -> !user.value.selected } || users.any { user -> user.value.selected && transaction.value.user.name == user.value.name }) // todo replace name with id
            }.toMutableStateList()
            filteredTransactions.forEach{ sum + it.value.amount }
            return filteredTransactions
        }

        /**
         * The value returned by this is shown on the home screen in the bottom bar.
         * This could be e.g. the amount the current user is due to pay to the other users or something similar
         */
        fun getStatus(): String {
            return sum.toString()
        }
    }
}
