package de.rwhtaachen.kohlekompass

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import de.rwhtaachen.kohlekompass.addItem.AddItem
import de.rwhtaachen.kohlekompass.advancedSearch.AdvancedSearch
import de.rwhtaachen.kohlekompass.home.HomePage
import de.rwhtaachen.kohlekompass.manageTags.ManageTags
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.launch


data class Page(
    val title: String,
    val icon: Painter,
    val content: @Composable () -> Unit
)


class MainActivity : ComponentActivity() {
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
                    Page(getString(R.string.add_item), rememberVectorPainter(Icons.Default.Add)) {
                        AddItem(
                            focusManager = focusManager,
                            drawerState = drawerState,
                            context = this,
                            scope = scope
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
                    }
                )

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Column {
                                pages.forEach { page ->
                                    DrawerItem(
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
    }
}

@Composable
fun DrawerItem(
    text: String,
    icon: Painter,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = onClick)
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