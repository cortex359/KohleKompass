package de.rwhtaachen.kohlekompass.data.source.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
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
    fun observeAll(): Flow<List<LocalTransaction>>
}