package de.rwhtaachen.kohlekompass

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.source.local.KohleKompassDatabase
import de.rwhtaachen.kohlekompass.di.AppDataContainer

@RequiresApi(Build.VERSION_CODES.O)
class KohleKompassApplication : Application() {
    private lateinit var container: AppDataContainer
    val database: KohleKompassDatabase by lazy { KohleKompassDatabase.getDatabase(this) }
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
