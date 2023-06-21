package de.rwhtaachen.kohlekompass

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import de.rwhtaachen.kohlekompass.data.source.local.KohleKompassDatabase

class KohleKompass : Application() {
    companion object {
        lateinit var database: KohleKompassDatabase
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext, KohleKompassDatabase::class.java,
            "local_database")
            .build()
    }
}