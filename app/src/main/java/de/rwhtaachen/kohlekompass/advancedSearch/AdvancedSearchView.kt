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
import de.rwhtaachen.kohlekompass.advancedSearch.SavedSearchManager.Companion.addSavedSearch
import de.rwhtaachen.kohlekompass.data.SavedSearch
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.home.ContentList
import de.rwhtaachen.kohlekompass.home.EditTransactionDialog
import de.rwhtaachen.kohlekompass.home.TopNavBarWithSearchBar
import de.rwhtaachen.kohlekompass.home.TransactionManager
import de.rwhtaachen.kohlekompass.manageTags.TagManager
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import java.time.LocalDate


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
    val startDate = remember { mutableStateOf<LocalDate?>(null) }
    val endDate = remember { mutableStateOf<LocalDate?>(null) }
    val users = remember { UserManager.getMutableStateUserList() }
    val tags = remember { TagManager.getMutableTagList() }
    val showResults = remember { mutableStateOf(false) }
    val showEditTransactionDialog = remember { mutableStateOf(false) }
    val currentTransaction = remember { mutableStateOf<Transaction?>(null) }

    if (showEditTransactionDialog.value) {
        EditTransactionDialog(
            context = context,
            focusManager = focusManager,
            transaction = currentTransaction.value!!,
            setShowDialog = { showEditTransactionDialog.value = it },
            setValue = {
                TransactionManager.updateTransaction(currentTransaction.value!!, it)
            })
    }

    val showSaveSearchDialog = remember { mutableStateOf(false) }
    if (showSaveSearchDialog.value) {
        InputFieldsDialog(
            title = context.getString(R.string.save_search_dialog_title),
            submitButtonText = context.getString(R.string.save_search_dialog_submit_button_text),
            fields = listOf("Title"),
            setShowDialog = { showSaveSearchDialog.value = it }) { it ->
            showSaveSearchDialog.value = false
            addSavedSearch(
                SavedSearch(
                    title = it["Title"]!!,
                    query = mainSearchBarState.value.text,
                    startDate = if (startDate.value == null) null else LocalDate.now(),
                    endDate = if (endDate.value == null) null else LocalDate.now(),
                    tags = if (tags.all { tag -> tag.value.selected }) null
                    else tags.filter { tag -> tag.value.selected }.map { it.value }.toSet(),
                    users = if (users.all { user -> user.value.selected }) null
                    else users.filter { user -> user.value.selected }.map { it.value }.toSet(),
                )
            )
        }
    }

    val showLoadSearchDialog = remember { mutableStateOf(false) }
    if (showLoadSearchDialog.value) {
        LoadSearchDialog(
            context = context,
            setShowDialog = { showLoadSearchDialog.value = it }) { search ->
            showLoadSearchDialog.value = false
            mainSearchBarState.value = TextFieldValue(search.query ?: "")
            startDate.value = search.startDate
            endDate.value = search.endDate
            if (search.tags != null) tags.forEach { tag ->
                tag.value = tag.value.copy(selected = search.tags.any { it.name == tag.value.name })
            }
            if (search.users != null) users.forEach { user ->
                user.value =
                    user.value.copy(selected = search.users.any { it.name == user.value.name })
            }
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
                if (showResults.value) {
                    val filteredTransactions = TransactionManager.getFilteredTransactions(
                        mainSearchBarState.value.text,
                        startDate.value,
                        endDate.value,
                        tags,
                        users
                    )
                    Row(Modifier.weight(1f, true)) {
                        ContentList(
                            transactions = filteredTransactions,
                            focusManager = focusManager,
                            padding = padding,
                            context = context,
                            showEditTransactionDialog = showEditTransactionDialog,
                            currentTransaction = currentTransaction
                        )
                    }
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Column(modifier = Modifier.weight(1f)) {// Date selection
                            DatePickerCard(
                                dateDescription = context.getString(R.string.start_date),
                                defaultText = context.getString(R.string.empty_date_format),
                                context = context,
                                date = startDate,
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {// Date selection
                            DatePickerCard(
                                dateDescription = context.getString(R.string.end_date),
                                defaultText = context.getString(R.string.today),
                                context = context,
                                date = endDate,
                            )
                        }
                    }
                    Row(Modifier.weight(3f, true)) {// Tag and user selection
                        Column(modifier = Modifier.weight(1f)) {// Tag selection
                            TagSelection(tagSearchBarState, focusManager, tags, context)
                        }
                        Column(modifier = Modifier.weight(1f)) {// User selection
                            UserSelection(focusManager, context, users)
                        }
                    }
                }
                Row {
                    BottomActionBar(
                        context,
                        listOf(
                            showSaveSearchDialog,
                            showLoadSearchDialog,
                            showDistributeDialog
                        ),
                        showResults = showResults,
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
    KohleKompassTheme {
        AdvancedSearch(
            focusManager = LocalFocusManager.current,
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
            scope = rememberCoroutineScope(),
            context = LocalContext.current
        )
    }
}
