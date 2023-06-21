package de.rwhtaachen.kohlekompass

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.room.Room
import de.rwhtaachen.kohlekompass.addTransaction.AddTransaction
import de.rwhtaachen.kohlekompass.advancedSearch.AdvancedSearch
import de.rwhtaachen.kohlekompass.data.TransactionRepository
import de.rwhtaachen.kohlekompass.data.source.local.KohleKompassDatabase
import de.rwhtaachen.kohlekompass.data.source.local.LocalTransaction
import de.rwhtaachen.kohlekompass.home.HomePage
import de.rwhtaachen.kohlekompass.manageSavedSearches.ManageSavedSearches
import de.rwhtaachen.kohlekompass.manageTags.ManageTags
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.launch


data class Page(
    val title: String,
    val icon: Painter,
    val content: @Composable () -> Unit
)

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    companion object {
        lateinit var db: KohleKompassDatabase
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KohleKompassTheme {
                val colors = MaterialTheme.colorScheme
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val focusManager = LocalFocusManager.current

                val selectedPage = remember { mutableStateOf(0) }
                val pages = listOf(
                    Page(
                        getString(R.string.home_page), rememberVectorPainter(Icons.Default.Home)
                    ) {
                        HomePage(
                            drawerState = drawerState,
                            scope = scope,
                            focusManager = focusManager,
                            context = this,
                            selectedPage = selectedPage
                        )
                    },
                    Page(getString(R.string.add_transaction), rememberVectorPainter(Icons.Default.Add)) {
                        AddTransaction(
                            focusManager = focusManager,
                            drawerState = drawerState,
                            context = this,
                            scope = scope,
                            selectedPage = selectedPage
                        )
                    },
                    Page(
                        getString(R.string.advanced_search),
                        rememberVectorPainter(Icons.Default.Search)
                    ) {
                        AdvancedSearch(
                            focusManager = focusManager,
                            drawerState = drawerState,
                            scope = scope,
                            context = this
                        )
                    },
                    Page(
                        title = getString(R.string.tags_page_title),
                        icon = painterResource(R.drawable.outline_sell_24)
                    ) {
                        ManageTags(
                            context = this,
                            drawerState = drawerState,
                            scope = scope,
                            focusManager = focusManager
                        )
                    },
                    Page(
                        title = getString(R.string.savedSearches_page_title),
                        icon = painterResource(R.drawable.baseline_saved_search_24)
                    ) {
                        ManageSavedSearches(
                            context = this,
                            drawerState = drawerState,
                            scope = scope,
                            focusManager = focusManager
                        )
                    }
                )

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            val maxWidth = (pages.maxOf { it.title.length } * 16).dp
                            Column (Modifier.width(maxWidth)){
                                pages.forEach { page ->
                                    DrawerTransaction(
                                        text = page.title,
                                        icon = page.icon,
                                        isSelected = (page == pages[selectedPage.value]),
                                        onClick = {
                                            selectedPage.value = pages.indexOf(page)
                                            scope.launch { drawerState.close() }
                                        }
                                    )
                                }
                            }
                        }
                    },
                    gesturesEnabled = true
                ) {
                    pages[selectedPage.value].content()
                }
            }
        }

        db = Room.databaseBuilder(
            applicationContext,
            KohleKompassDatabase::class.java, "KohleKompassDatabase"
        ).build()
        val repository = LocalTransaction(
            (application as KohleKompassApplication)
                .database
                .transactionDao()
        )
    }

    // @TODO: Activity Lifecycle:
    override fun onStart() {
        super.onStart()
        Log.i(TAG,"First.onStart")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        Log.i(TAG,"First.onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"First.onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"First.onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"First.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"First.onDestroy, ref $this")
    }

    // after onPause
    override fun onSaveInstanceState(savedInstanceState: Bundle) { // Save something
        val key = "save_key"
        savedInstanceState.putString(key, "something")
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG,"First.onSaveInstanceState")
    }

    // is called after onStart(), whereas onCreate() is called before onStart()
    // called only when recreating activity after it was killed
    // same bundle as in onCreate
    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG,"First.onRestoreInstanceState")
        // restore something
        val key = "save_keys"
        val value = savedInstanceState.getString(key)
        Log.i(TAG,"First.onRestoreInstanceState: value='$value'")
    }
}

@Composable
fun DrawerTransaction(
    text: String,
    icon: Painter,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = text,
            color = if (isSelected) colors.primary else colors.onSurface
        )
    }
}