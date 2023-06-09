package de.rwhtaachen.kohlekompass.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room Database to contain the Transaction table for the groups.
 * exportSchema should be true in production
 */
@Database(entities = [LocalTransaction::class], version = 1, exportSchema = false)
abstract class KohleKompassDatabase : RoomDatabase() {
    abstract fun taskDao(): TransactionDao
}