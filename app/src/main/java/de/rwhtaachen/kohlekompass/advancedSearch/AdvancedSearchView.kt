package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import de.rwhtaachen.kohlekompass.data.examples.savedSearches
import de.rwhtaachen.kohlekompass.home.TopNavBarWithSearchBar
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedSearch(
    focusManager: FocusManager,
    drawerState: DrawerState,
    scope: CoroutineScope,
    context: Context
) {
    val mainSearchBarState = remember { mutableStateOf(TextFieldValue("")) }
    val tagSearchBarState = remember { mutableStateOf(TextFieldValue("")) }
    val fromDate = remember { mutableStateOf("") }
    val toDate = remember { mutableStateOf("") }
    val users = remember { UserManager.getUserList() }

    val showSaveSearchDialog = remember { mutableStateOf(false) }
    if (showSaveSearchDialog.value) {
        InputFieldsDialog(
            title = context.getString(R.string.save_search_dialog_title),
            submitButtonText = context.getString(R.string.save_search_dialog_submit_button_text),
            fields = listOf("Name"),
            setShowDialog = { showSaveSearchDialog.value = it }) {
            showSaveSearchDialog.value = false
            savedSearches.add(it["Name"]!!)
        }
    }

    val showLoadSearchDialog = remember { mutableStateOf(false) }
    if (showLoadSearchDialog.value) {
        LoadSearchDialog(context = context, setShowDialog = { showLoadSearchDialog.value = it }) {
            showLoadSearchDialog.value = false
            // TODO: Load search
        }
    }

    val showDistributeDialog = remember { mutableStateOf(false) }
    if (showDistributeDialog.value) {
        DistributeDialog(
            context = context,
            focusManager = focusManager,
            users = users.map { it.value }.filter { it.selected },
            setShowDialog = { showDistributeDialog.value = it }) {
            showDistributeDialog.value = false
            // TODO: Create Distribution with users
        }
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() })
            },
        topBar = {
            TopNavBarWithSearchBar(
                searchBarState = mainSearchBarState,
                drawerState = drawerState,
                scope = scope,
                focusManager = focusManager,
                context = context,
                selectedPage = remember { mutableStateOf(2) }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    Column(modifier = Modifier.weight(1f)) {// Date selection
                        DatePickerCard(
                            dateDescription = context.getString(R.string.start_date),
                            defaultText = context.getString(R.string.empty_date_format),
                            date = fromDate,
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {// Date selection
                        DatePickerCard(
                            dateDescription = context.getString(R.string.end_date),
                            defaultText = context.getString(R.string.today),
                            date = toDate,
                        )
                    }
                }
                Row(Modifier.weight(3f, true)) {// Tag and user selection
                    Column(modifier = Modifier.weight(1f)) {// Tag selection
                        TagSelection(tagSearchBarState, focusManager, context)
                    }
                    Column(modifier = Modifier.weight(1f)) {// User selection
                        UserSelection(focusManager, context, users)
                    }
                }
                Row {
                    BottomActionBar(
                        context,
                        listOf(showSaveSearchDialog, showLoadSearchDialog, showDistributeDialog)
                    )
                }
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AdvancedSearchPreview() {
    KohleKompassTheme() {
        AdvancedSearch(
            focusManager = LocalFocusManager.current,
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
            scope = rememberCoroutineScope(),
            context = LocalContext.current
        )
    }
}
