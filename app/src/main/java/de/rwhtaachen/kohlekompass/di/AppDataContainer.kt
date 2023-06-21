package de.rwhtaachen.kohlekompass.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.TransactionRepository
import de.rwhtaachen.kohlekompass.data.source.local.KohleKompassDatabase
import de.rwhtaachen.kohlekompass.data.source.local.LocalTransaction

interface AppContainer {
    val transactionRepository: TransactionRepository
}

@RequiresApi(Build.VERSION_CODES.O)
class AppDataContainer(private val context: Context) : AppContainer {
    override val transactionRepository: TransactionRepository by lazy {
        LocalTransaction(KohleKompassDatabase.getDatabase(context).transactionDao())
    }
}