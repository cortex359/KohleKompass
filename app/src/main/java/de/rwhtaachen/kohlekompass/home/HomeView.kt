package de.rwhtaachen.kohlekompass.home

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.SearchField
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    focusManager: FocusManager,
    drawerState: DrawerState,
    scope: CoroutineScope,
    context: Context,
    selectedPage: MutableState<Int>
) {
    val searchBarState = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() })
            },
        topBar = {
            TopNavBarWithSearchBar(
                searchBarState = searchBarState,
                drawerState = drawerState,
                scope = scope,
                focusManager = focusManager,
                context = context,
                selectedPage = selectedPage
            )
        },
        content = { padding ->
            ContentList(
                state = searchBarState,
                focusManager = focusManager,
                padding = padding
            )
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBarWithSearchBar(
    searchBarState: MutableState<TextFieldValue>,
    drawerState: DrawerState,
    scope: CoroutineScope,
    focusManager: FocusManager,
    context: Context,
    selectedPage: MutableState<Int>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val colors = MaterialTheme.colorScheme
        // Menu
        IconButton(
            onClick = {
                scope.launch {
                    drawerState.open()
                }
            }
        ) {
            Icon(
                Icons.Default.Menu,
                contentDescription = context.getString(R.string.open_menu),
                tint = colors.primary
            )
        }

        // Search Bar
        Box(
            modifier = Modifier
                .weight(3f, true)
        ) {
            SearchField(
                searchBarState = searchBarState,
                focusManager = focusManager,
                modifier = Modifier.border(
                    width = 1.dp,
                    color = colors.onPrimary,
                    shape = MaterialTheme.shapes.extraLarge
                ),
            )
        }

        // Add Item
        IconButton(
            onClick = {
                scope.launch { drawerState.close() }
                selectedPage.value = 1
            }
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = context.getString(R.string.add_item),
                tint = colors.primary
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContentList(
    state: MutableState<TextFieldValue>,
    focusManager: FocusManager,
    padding: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        val items = getItems()
        items(items.size) { index ->
            val item = items[index]
            if (state.value.text.isEmpty()
                || item.title.lowercase().contains(state.value.text.lowercase())
                || item.user.name.lowercase().contains(state.value.text.lowercase())
            ) {
                ContentItem(item)
            }
        }
    }
}

@Composable
fun ContentItem(item: Item) {
    val colors = MaterialTheme.colorScheme
    val shape = MaterialTheme.shapes.medium
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            .background(colors.primaryContainer, shape)
            .border(1.dp, colors.onPrimaryContainer, shape)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(item.title, color = colors.onPrimaryContainer)
                Text(item.user.name, color = colors.onPrimaryContainer)
            }
            Text(item.amount, color = colors.onPrimaryContainer)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomePageScreenPreview() {
    KohleKompassTheme() {
        HomePage(
            focusManager = LocalFocusManager.current,
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
            scope = rememberCoroutineScope(),
            context = LocalContext.current,
            selectedPage = remember { mutableStateOf(0) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopNavBarPreview() {
    KohleKompassTheme() {
        TopNavBarWithSearchBar(
            searchBarState = remember { mutableStateOf(TextFieldValue("")) },
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
            scope = rememberCoroutineScope(),
            focusManager = LocalFocusManager.current,
            context = LocalContext.current,
            selectedPage = remember { mutableStateOf(0) }
        )
    }
}