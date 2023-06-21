package de.rwhtaachen.kohlekompass.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import de.rwhtaachen.kohlekompass.data.Group
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
    // WHERE group = group_id
    @Query("SELECT * FROM transactions ORDER BY id DESC")
    suspend fun observeAll(): Flow<List<Transaction>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)
    @Update
    suspend fun update(transaction: Transaction)
    @Delete
    suspend fun delete(transaction: Transaction)

    @androidx.room.Transaction
    @Query("SELECT * FROM transactions WHERE group LIKE :id")
    fun getTransactions(group: Group): List<Transaction>
}