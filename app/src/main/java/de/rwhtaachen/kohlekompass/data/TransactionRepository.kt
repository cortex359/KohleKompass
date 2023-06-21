package de.rwhtaachen.kohlekompass.data

import kotlinx.coroutines.flow.Flow
interface TransactionRepository {
    suspend fun getTranactionListFlow(): Flow<List<Transaction>>
    suspend fun insertTransaction(transaction: Transaction)
    suspend fun deleteTransaction(transaction: Transaction)
    suspend fun updateTransaction(transaction: Transaction)
    suspend fun isEmpty(): Boolean
}
