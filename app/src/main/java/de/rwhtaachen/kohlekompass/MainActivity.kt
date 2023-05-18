package de.rwhtaachen.kohlekompass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.pages.AddItem
import de.rwhtaachen.kohlekompass.pages.AdvancedSearch
import de.rwhtaachen.kohlekompass.pages.HomePage

import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class ListItem(val description: String, val user: String, val amount: String)

data class Page @OptIn(ExperimentalMaterial3Api::class) constructor(
    val title: String,
    val icon: ImageVector,
    val content: @Composable () -> Unit
)


// example data
val listItems = listOf(
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€")
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KohleKompassTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val focusManager = LocalFocusManager.current
                val pages = listOf(
                    Page("Home", Icons.Default.Home) {
                        HomePage(
                            drawerState = drawerState,
                            scope = scope,
                            focusManager = focusManager
                        )
                    },
                    Page("Add Item", Icons.Default.Add) {
                        AddItem(
                            focusManager = focusManager,
                            drawerState = drawerState,
                            scope = scope
                        )
                    },
                    Page("Advanced Search", Icons.Default.Search) {
                        AdvancedSearch(
                            focusManager = focusManager,
                            drawerState = drawerState,
                            scope = scope
                        )
                    }
                )
                var selectedPage by remember { mutableStateOf(pages[0]) }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Column {
                                pages.forEach { page ->
                                    DrawerItem(
                                        text = page.title,
                                        icon = page.icon,
                                        isSelected = (page == selectedPage),
                                        onClick = {
                                            selectedPage = page
                                            scope.launch { drawerState.close() }
                                        }
                                    )
                                }
                            }
                        }
                    },
                    gesturesEnabled = true
                ) {
                    selectedPage.content()
                }
            }
        }
    }
}

@Composable
fun DrawerItem(
    text: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = text,
            color = if (isSelected) colors.primary else colors.onSurface
        )
    }
}
