package de.rwhtaachen.kohlekompass.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import de.rwhtaachen.kohlekompass.data.Transaction
import kotlinx.coroutines.flow.Flow


/**
 * Data Access Object for the transaction table.
 */
@Dao
interface TransactionDao {
    /**
     * Observes list of transactions.
     *
     * @return all transactions.
     */
    @Query("SELECT * FROM transactions")
    fun observeAll(): Flow<List<Transaction>>
    @Insert
    fun insertTransaction(transaction: Transaction)
    @Update
    fun updateTransaction(transaction: Transaction)
    @Delete
    fun deleteTransaction(transaction: Transaction)
}