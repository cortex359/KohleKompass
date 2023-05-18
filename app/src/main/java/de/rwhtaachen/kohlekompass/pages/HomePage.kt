package de.rwhtaachen.kohlekompass.pages

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.ListItem
import de.rwhtaachen.kohlekompass.listItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(focusManager: FocusManager, drawerState: DrawerState, scope: CoroutineScope) {
    val searchBarState = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() })
            },
        topBar = {
            TopNavBar(
                searchBarState = searchBarState,
                drawerState = drawerState,
                scope = scope,
                focusManager = focusManager
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
fun TopNavBar(
    searchBarState: MutableState<TextFieldValue>,
    drawerState: DrawerState,
    scope: CoroutineScope,
    focusManager: FocusManager
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Menu
        IconButton(
            onClick = {
                scope.launch { // todo app crashes
                    drawerState.open()
                }
            }
        ) {
            Icon(
                Icons.Default.Menu,
                contentDescription = "open menu",
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp)
            )
        }

        // Search Bar
        Box(
            modifier = Modifier
                .weight(3f, true)
                .height(50.dp)
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            SearchView(state = searchBarState, focusManager = focusManager)
        }

        // Add Element
        IconButton(
            onClick = {
            }
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "add Entry",
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp)
            )
        }
    }
}

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
            }) {
        items(listItems.size) { index ->
            val item = listItems[index]
            if (state.value.text.isEmpty()
                || item.description.lowercase().contains(state.value.text.lowercase())
                || item.user.lowercase().contains(state.value.text.lowercase())
            ) {
                ContentItem(item)
            }
        }
    }
}

@Composable
fun ContentItem(item: ListItem) {
    val shape = MaterialTheme.shapes.medium
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            .background(MaterialTheme.colorScheme.primaryContainer, shape)
            .border(1.dp, MaterialTheme.colorScheme.background, shape)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(item.description, style = MaterialTheme.typography.titleMedium)
                Text(item.user, style = MaterialTheme.typography.titleSmall)
            }
            Text(item.amount)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(state: MutableState<TextFieldValue>, focusManager: FocusManager) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.labelMedium,
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        focusManager.clearFocus()
                        state.value = TextFieldValue("")
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(5.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}