package de.rwhtaachen.kohlekompass.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.TransactionRepository
import kotlinx.coroutines.flow.Flow

/**
 * Internal model used to represent a transaction stored locally in a Room database.
 * [Data Layer]
 */
class LocalTransaction(private  val TransactionDao: TransactionDao) : TransactionRepository {
    override suspend fun getTranactionListFlow(): Flow<List<Transaction>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override suspend fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

}