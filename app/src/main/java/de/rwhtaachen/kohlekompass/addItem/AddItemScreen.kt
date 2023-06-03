package de.rwhtaachen.kohlekompass.addItem

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusManager
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItem(focusManager: FocusManager, drawerState: DrawerState, scope: CoroutineScope) {
    Text("add item coming soon")
}