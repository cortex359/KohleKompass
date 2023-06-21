package de.rwhtaachen.kohlekompass.data.source.local

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.rwhtaachen.kohlekompass.data.Transaction

/**
 * Room Database to contain the Transaction table for the groups.
 * exportSchema should be true in production
 */
@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class KohleKompassDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    companion object {
        private var Instance: KohleKompassDatabase? = null
        fun getDatabase(context: Context) : KohleKompassDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context,
                    KohleKompassDatabase::class.java,
                    "kohleKompassDatabase")
                    .fallbackToDestructiveMigration() // @TODO: remove in production!
                    .build()
                    .also { Instance = it }
            }
        }
    }
}