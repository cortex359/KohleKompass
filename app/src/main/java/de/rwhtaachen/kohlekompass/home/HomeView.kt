package de.rwhtaachen.kohlekompass.home

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import de.rwhtaachen.kohlekompass.SearchField
import de.rwhtaachen.kohlekompass.addTransaction.AddTagDialog
import de.rwhtaachen.kohlekompass.addTransaction.AddTransactionPageContent
import de.rwhtaachen.kohlekompass.addTransaction.SelectUserDialog
import de.rwhtaachen.kohlekompass.advancedSearch.UserManager.Companion.getCurrentUser
import de.rwhtaachen.kohlekompass.data.Money
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.User
import de.rwhtaachen.kohlekompass.data.source.example.tags
import de.rwhtaachen.kohlekompass.data.source.example.transactionList
import de.rwhtaachen.kohlekompass.data.source.example.userList
import de.rwhtaachen.kohlekompass.manageTags.TagManager
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate

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
            Column {
                Row(Modifier.weight(1f, true)) {
                    ContentList(
                        state = searchBarState,
                        focusManager = focusManager,
                        padding = padding,
                        context = context,
                        showEditTransactionDialog = showEditTransactionDialog,
                        currentTransaction = currentTransaction
                    )
                }
                BottomBar(context = context)
            }
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
                .weight(1f, true)
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

        // Add Transaction
        IconButton(
            onClick = {
                scope.launch { drawerState.close() }
                selectedPage.value = 1
            }
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = context.getString(R.string.add_transaction),
                tint = colors.primary
            )
        }
    }
}

@Composable
fun BottomBar(context: Context) {
    val colors = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .background(colors.secondary)
            .fillMaxWidth(),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = context.getString(R.string.home_bottom_text),
                color = colors.onSecondary,
                fontSize = 30.sp,
                modifier = Modifier.padding(5.dp)

            )
            Card(
                border = BorderStroke(
                    width = 1.dp,
                    color = colors.onSecondaryContainer
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colors.secondaryContainer
                ),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    getAmountDue(), color = colors.onSecondaryContainer,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContentList(
    state: MutableState<TextFieldValue>,
    focusManager: FocusManager,
    padding: PaddingValues,
    context: Context,
    showEditTransactionDialog: MutableState<Boolean>,
    currentTransaction: MutableState<Transaction?>
) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        reverseLayout = true
    ) {
        val transactions = TransactionManager.getTransactionList()
        items(transactions.size) { index ->
            val transaction = transactions[index]
            if (state.value.text.isEmpty()
                || transaction.value.title.lowercase().contains(state.value.text.lowercase())
                || transaction.value.user.name.lowercase().contains(state.value.text.lowercase())
            ) {
                TransactionListElement(
                    transaction,
                    context = context,
                    showEditTransactionDialog = showEditTransactionDialog,
                    currentTransaction = currentTransaction
                )
            }
        }
    }
}

@Composable
fun TransactionListElement(
    transaction: MutableState<Transaction>,
    context: Context,
    showEditTransactionDialog: MutableState<Boolean>,
    currentTransaction: MutableState<Transaction?>
) {
    val colors = MaterialTheme.colorScheme
    val shape = MaterialTheme.shapes.medium
    val tags = transaction.value.tags.toList()
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(10.dp, 5.dp)
            .height(70.dp)
    ) {
        UserNameWithProfilePicture(
            user = transaction.value.user,
            context = context,
            padding = PaddingValues(0.dp, 0.dp, 10.dp, 0.dp)
        )
        Column(Modifier.weight(1f, true)) {
            Box(
                modifier = Modifier
                    .clickable {
                        currentTransaction.value = transaction.value
                        showEditTransactionDialog.value = true
                    }
                    .background(colors.primaryContainer, shape)
                    .border(
                        if (transaction.value.user == getCurrentUser()) 3.dp else 1.dp,
                        colors.onPrimaryContainer, shape
                    )
                    .padding(10.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            transaction.value.title,
                            color = colors.onPrimaryContainer,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            transaction.value.value_date.toString(),
                            color = colors.onPrimaryContainer
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 5.dp, 0.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        LazyRow(Modifier.weight(1f, true)) {
                            items(tags.size) {
                                Card(
                                    modifier = Modifier.padding(0.dp, 0.dp, 2.dp, 0.dp),
                                    colors = CardDefaults.cardColors(containerColor = colors.secondaryContainer),
                                    border = BorderStroke(1.dp, colors.onSecondaryContainer),
                                    shape = MaterialTheme.shapes.extraSmall,
                                ) {
                                    Text(
                                        tags[it].name.replaceFirstChar { it.uppercase() },
                                        modifier = Modifier.padding(3.dp)
                                    )
                                }
                            }
                        }
                        Text(
                            transaction.value.amount.toString(),
                            color = colors.onPrimaryContainer,
                            modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp),
                            fontWeight = FontWeight.Bold
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun UserNameWithProfilePicture(user: User, context: Context, padding: PaddingValues) {
    Column(
        Modifier.padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = user.profilePicture),
            contentDescription = context.getString(R.string.profile_picture_description),
            modifier = Modifier.weight(1f, true)
        )
        Text(
            text = user.name,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}


@Preview
@Composable
fun UserNameWithProfilePicturePreview() {
    KohleKompassTheme {
        UserNameWithProfilePicture(
            user = userList[0],
            context = LocalContext.current,
            padding = PaddingValues(5.dp)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditTransactionDialog(
    transaction: Transaction,
    focusManager: FocusManager,
    context: Context,
    setShowDialog: (Boolean) -> Unit,
    setValue: (Transaction) -> Unit
) {
    val colors = MaterialTheme.colorScheme
    val date = remember { mutableStateOf(transaction.value_date) }
    val selectedUser = remember { mutableStateOf(transaction.user) }
    val textFieldState = remember { mutableStateOf(TextFieldValue(transaction.title)) }
    val amountTextFieldState = remember {
        mutableStateOf(TextFieldValue(transaction.amount.toString()))
    }

    val showSelectUserDialog = remember { mutableStateOf(false) }
    val showAddTagDialog = remember { mutableStateOf(false) }

    val transactionTags = TagManager.getMutableTagList()
    transactionTags.forEach { tag ->
        tag.value.selected = transaction.tags.any { it.name == tag.value.name }
    }
    val tags = remember { transactionTags }

    if (showSelectUserDialog.value) {
        SelectUserDialog(
            focusManager = focusManager,
            context = context,
            { showSelectUserDialog.value = it },
            {
                selectedUser.value = it
                showSelectUserDialog.value = false
            }
        )
    }

    if (showAddTagDialog.value) {
        AddTagDialog(
            focusManager = focusManager,
            context = context,
            tags = tags,
            { showAddTagDialog.value = it },
            { tag ->
                tags[tags.indexOf(tag)].value = tag.value.copy(selected = true)
                showAddTagDialog.value = false
            }
        )
    }

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = colors.surface
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(25.dp, 25.dp, 25.dp, 5.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = context.getString(R.string.edit_transaction_dialog_title),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = colors.onPrimaryContainer,
                        )
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = colors.onPrimaryContainer,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }
                    AddTransactionPageContent(
                        padding = PaddingValues(5.dp),
                        focusManager = focusManager,
                        context = context,
                        date = date,
                        selectedUser = selectedUser,
                        showSelectUserDialog = showSelectUserDialog,
                        showAddTagDialog = showAddTagDialog,
                        tags = tags,
                        submitButtonText = context.getString(R.string.edit_transaction_dialog_submit_button_text),
                        submitTransaction = { editedTransaction ->
                            setValue(editedTransaction)
                            setShowDialog(false)
                        },
                        textFieldState = textFieldState,
                        amountTextFieldState = amountTextFieldState,
                    )
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun EditTransactionDialogPreview() {
    KohleKompassTheme {
        EditTransactionDialog(
            context = LocalContext.current,
            focusManager = LocalFocusManager.current,
            setShowDialog = {},
            setValue = {},
            transaction = transactionList[0]
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TransactionListElementPreview() {
    KohleKompassTheme {
        TransactionListElement(
            remember {
                mutableStateOf(
                    Transaction(
                        title = "Grocery shopping",
                        amount = Money(50.25),
                        user = userList[0],
                        value_date = LocalDate.now(),
                        local_date = LocalDate.now(),
                        sync_date = LocalDate.now(),
                        tags = mutableSetOf(
                            tags["groceries"]!!,
                            tags["travel"]!!,
                            tags["toiletries"]!!,
                            tags["bills"]!!,
                            tags["dining"]!!,
                            tags["entertainment"]!!
                        )
                    )
                )
            },
            context = LocalContext.current,
            showEditTransactionDialog = remember { mutableStateOf(false) },
            currentTransaction = remember { mutableStateOf(null) }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomePageScreenPreview() {
    KohleKompassTheme {
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
    KohleKompassTheme {
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