package de.rwhtaachen.kohlekompass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.addItem.AddItem
import de.rwhtaachen.kohlekompass.advancedSearch.AdvancedSearch
import de.rwhtaachen.kohlekompass.home.HomePage
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.launch


data class Page @OptIn(ExperimentalMaterial3Api::class) constructor(
    val title: String,
    val icon: ImageVector,
    val content: @Composable () -> Unit
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
                    Page(getString(R.string.home_page), Icons.Default.Home) {
                        HomePage(
                            drawerState = drawerState,
                            scope = scope,
                            focusManager = focusManager,
                            context = this
                        )
                    },
                    Page(getString(R.string.add_item), Icons.Default.Add) {
                        AddItem(
                            focusManager = focusManager,
                            drawerState = drawerState,
                            scope = scope
                        )
                    },
                    Page(getString(R.string.advanced_search), Icons.Default.Search) {
                        AdvancedSearch(
                            focusManager = focusManager,
                            drawerState = drawerState,
                            scope = scope,
                            context = this
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    searchBarState: MutableState<TextFieldValue>,
    focusManager: FocusManager,
    shape: Shape = RectangleShape,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        cursorColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
) {
    TextField(
        value = searchBarState.value,
        onValueChange = { value ->
            searchBarState.value = value
        },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
            )
        },
        trailingIcon = {
            if (searchBarState.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        focusManager.clearFocus()
                        searchBarState.value = TextFieldValue("")
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = ""
                    )
                }
            }
        },
        singleLine = true,
        shape = shape, // The TextFiled has rounded corners top left and right by default
        colors = colors
    )
}

@Preview
@Composable
fun SearchFieldPreview() {
    val searchBarState = remember { mutableStateOf(TextFieldValue("")) }
    SearchField(searchBarState, LocalFocusManager.current)
}