package de.rwhtaachen.kohlekompass.addItem

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.rwhtaachen.kohlekompass.advancedSearch.DatePickerCard
import de.rwhtaachen.kohlekompass.advancedSearch.UserManager
import de.rwhtaachen.kohlekompass.data.Money
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.User
import de.rwhtaachen.kohlekompass.home.ItemManager
import de.rwhtaachen.kohlekompass.manageTags.TagManager
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItem(
    focusManager: FocusManager,
    context: Context,
    drawerState: DrawerState,
    scope: CoroutineScope,
    selectedPage: MutableState<Int>
) {
    val colors = MaterialTheme.colorScheme
    val selectedDate = remember { mutableStateOf(LocalDate.now()) }
    val selectedUser = remember { mutableStateOf(UserManager.getCurrentUser()) }
    val showSelectUserDialog = remember { mutableStateOf(false) }
    val textFieldState = remember { mutableStateOf(TextFieldValue("")) }
    val amountTextFieldState = remember { mutableStateOf(TextFieldValue("")) }

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

    val showAddTagDialog = remember { mutableStateOf(false) }
    val tags = remember { TagManager.getMutableTagList() }

    if (showAddTagDialog.value) {
        AddTagDialog(
            focusManager = focusManager,
            context = context,
            tags = tags,
            { showAddTagDialog.value = it },
            { tag ->
                tags[tags.indexOf(tag)].value = tag.value.copy(selected = true)
                showAddTagDialog.value = false
            },
        )
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() })
            },
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = context.getString(R.string.add_item),
                            color = colors.primary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(weight = 1f, fill = true),
                            textAlign = TextAlign.Center
                        )
                        // go to home page
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedPage.value = 0
                            }
                        ) {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = context.getString(R.string.home_page),
                                tint = colors.primary
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (drawerState.isOpen) {
                                scope.launch { drawerState.close() }
                            } else {
                                scope.launch { drawerState.open() }
                            }
                        }
                    ) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = context.getString(R.string.open_menu),
                            tint = colors.primary
                        )
                    }
                },

                )
        },
        content = { padding ->
            AddItemPageContent(
                padding = padding,
                focusManager = focusManager,
                context = context,
                date = selectedDate,
                selectedUser = selectedUser,
                showSelectUserDialog = showSelectUserDialog,
                showAddTagDialog = showAddTagDialog,
                tags = tags,
                textFieldState = textFieldState,
                amountTextFieldState = amountTextFieldState
            )
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemPageContent(
    padding: PaddingValues,
    focusManager: FocusManager,
    context: Context,
    date: MutableState<LocalDate>,
    selectedUser: MutableState<User>,
    showSelectUserDialog: MutableState<Boolean>,
    showAddTagDialog: MutableState<Boolean>,
    tags: MutableList<MutableState<Tag>>,
    submitItem: (Transaction) -> Unit = { ItemManager.addItem(it) },
    submitButtonText: String = context.getString(R.string.add_item_submit_button_text),
    textFieldState: MutableState<TextFieldValue>,
    amountTextFieldState: MutableState<TextFieldValue>
) {
    val colors = MaterialTheme.colorScheme
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(padding)
            .padding(20.dp)
    ) {
        Row {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        BorderStroke(
                            width = 1.dp,
                            color = colors.onPrimary
                        ),
                        shape = RoundedCornerShape(50)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    containerColor = MaterialTheme.colorScheme.primary,
                    focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                    focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary
                ),
                trailingIcon = {
                    if (textFieldState.value != TextFieldValue("")) {
                        IconButton(
                            onClick = {
                                focusManager.clearFocus()
                                textFieldState.value = TextFieldValue("")
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = context.getString(R.string.close_icon_description)
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                shape = RoundedCornerShape(50),
                placeholder = {
                    Text(
                        context.getString(R.string.item_description_text_field),
                        color = colors.onPrimary
                    )
                },
                value = textFieldState.value,
                onValueChange = {
                    textFieldState.value = it
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(1f, true)
                .verticalScroll(scrollState)
        ) {
            Row(modifier = Modifier.height(100.dp)) {
                Column(Modifier.weight(1f)) {
                    DatePickerCard(
                        dateDescription = "",
                        context = context,
                        date = date,
                        padding = PaddingValues(5.dp, 5.dp, 2.5.dp, 2.5.dp)
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showSelectUserDialog.value = true }
                            .padding(5.dp, 2.5.dp, 2.5.dp, 5.dp)
                            .border(
                                1.dp,
                                colors.onPrimaryContainer,
                                MaterialTheme.shapes.medium
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = colors.primaryContainer
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = selectedUser.value.name,
                                fontWeight = FontWeight.Bold,
                                color = colors.onPrimaryContainer,
                                modifier = Modifier.padding(5.dp)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                                contentDescription = context.getString(R.string.user_icon_description),
                                modifier = Modifier
                                    .padding(5.dp)
                                    .size(24.dp),
                                tint = colors.onPrimaryContainer
                            )
                        }
                    }
                }
                Column(Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AmountTextField(
                            amountTextFieldState = amountTextFieldState,
                            context = context
                        )
                    }
                }
            }
            Row {
                TagSelection(
                    context = context,
                    searchFieldState = textFieldState,
                    focusManager = focusManager,
                    tags = tags,
                    showAddTagDialog = showAddTagDialog
                )
            }
        }
        Row {// submit button
            Button(
                onClick = {
                    if (textFieldState.value.text != "") {
                        val item = Transaction(
                            title = textFieldState.value.text,
                            amount = Money(amountTextFieldState.value.text.toString()),
                            value_date = date.value,
                            local_date = LocalDate.now(),
                            sync_date = null,
                            user = selectedUser.value,
                            tags = tags.filter { it.value.selected }.map { it.value }
                                .toMutableSet()
                        )
                        submitItem(item)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 5.dp, 5.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.secondary,
                    contentColor = colors.onSecondaryContainer
                )
            ) {
                Text(
                    submitButtonText,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
fun TagSelection(
    context: Context,
    searchFieldState: MutableState<TextFieldValue>,
    focusManager: FocusManager,
    tags: MutableList<MutableState<Tag>>,
    showAddTagDialog: MutableState<Boolean>
) {
    val colors = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .padding(5.dp, 0.dp, 5.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, colors.onPrimaryContainer),
        colors = CardDefaults.cardColors(
            containerColor = colors.primaryContainer
        )
    ) {
        Column {
            Row {
                Text(
                    context.getString(R.string.selected_tags_card_title),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
            }
            Row {
                Card( // add tag card
                    modifier = Modifier
                        .padding(5.dp, 5.dp, 0.dp, 5.dp)
                        .clickable(onClick = {
                            showAddTagDialog.value = true
                        })
                        .drawBehind {
                            drawRoundRect(
                                color = colors.onSecondaryContainer,
                                style = Stroke(
                                    width = 3f,
                                    pathEffect = PathEffect.dashPathEffect(
                                        floatArrayOf(10f, 10f),
                                        0f
                                    )
                                ),
                                cornerRadius = CornerRadius(10.dp.toPx())
                            )
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = colors.secondaryContainer
                    )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = context.getString(R.string.tag_icon_description),
                            modifier = Modifier
                                .padding(5.dp, 5.dp, 0.dp, 5.dp)
                                .size(20.dp),
                            tint = colors.onSecondaryContainer
                        )
                        Text(
                            context.getString(R.string.add_tag_card_title),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(5.dp),
                            color = colors.onSecondaryContainer
                        )
                    }
                }
                LazyRow(content = {
                    items(tags.size) {
                        if (tags[it].value.selected) {
                            Card(
                                modifier = Modifier
                                    .padding(5.dp, 5.dp, 0.dp, 5.dp)
                                    .clickable(onClick = {
                                        tags[it] =
                                            mutableStateOf(tags[it].value.copy(selected = false))
                                        focusManager.clearFocus()
                                    }),
                                border = BorderStroke(1.dp, colors.onSecondaryContainer),
                                colors = CardDefaults.cardColors(
                                    containerColor = colors.secondaryContainer
                                )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.outline_sell_24),
                                        contentDescription = context.getString(R.string.tag_icon_description),
                                        modifier = Modifier
                                            .padding(5.dp, 5.dp, 0.dp, 5.dp)
                                            .size(20.dp),
                                        tint = colors.onSecondaryContainer
                                    )
                                    Text(
                                        tags[it].value.name,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(5.dp)
                                    )
                                }
                            }
                        }
                    }
                })
            }
            Row {
                Text(
                    context.getString(R.string.tag_suggestions_card_title),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
            }
            Row {
                TagSuggestions(
                    context = context,
                    textFieldState = searchFieldState,
                    tags = tags,
                    focusManager = focusManager
                )
            }
        }
    }
}


@Composable
fun TagSuggestions(
    context: Context,
    textFieldState: MutableState<TextFieldValue>,
    tags: MutableList<MutableState<Tag>>,
    focusManager: FocusManager
) {
    val colors = MaterialTheme.colorScheme
    val suggestedTags =
        (if (textFieldState.value.text == "") remember { mutableStateListOf() }
        else tags.filter { tag ->
            !tag.value.selected && (
                    tag.value.keywords.any { k -> k.contains(textFieldState.value.text.lowercase()) }
                            || tag.value.keywords.any { k ->
                        textFieldState.value.text.lowercase().contains(k)
                    })
        }).toMutableList()

    LazyRow(content = {
        items(suggestedTags.size) {
            Card(
                modifier = Modifier
                    .padding(5.dp, 5.dp, 0.dp, 5.dp)
                    .clickable(onClick = {
                        tags[tags.indexOf(suggestedTags[it])] =
                            mutableStateOf(suggestedTags[it].value.copy(selected = true))
                        focusManager.clearFocus()
                    }),
                border = BorderStroke(1.dp, colors.onSecondaryContainer),
                colors = CardDefaults.cardColors(
                    containerColor = colors.secondaryContainer
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_sell_24),
                        contentDescription = context.getString(R.string.tag_icon_description),
                        modifier = Modifier
                            .padding(5.dp, 5.dp, 0.dp, 5.dp)
                            .size(20.dp),
                        tint = colors.onSecondaryContainer
                    )
                    Text(
                        suggestedTags[it].value.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }
    })
    if (suggestedTags.isEmpty()) {
        Spacer(modifier = Modifier.height(35.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmountTextField(
    context: Context,
    amountTextFieldState: MutableState<TextFieldValue>,
) {
    val colors = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, colors.onPrimaryContainer),
        colors = CardDefaults.cardColors(
            containerColor = colors.primaryContainer
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = amountTextFieldState.value,
                onValueChange = { amountTextFieldState.value = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                trailingIcon = {
                    Icon(
                        painterResource(id = R.drawable.outline_kohlekompass),
                        contentDescription = context.getString(R.string.kohlekompass_icon_description),
                        modifier = Modifier.size(40.dp),
                        tint = colors.onPrimaryContainer
                    )
                },
                shape = RoundedCornerShape(5.dp),
                textStyle = LocalTextStyle.current.copy(
                    color = colors.onPrimaryContainer,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colors.primaryContainer,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = colors.onPrimaryContainer,
                    textColor = colors.onPrimaryContainer
                )
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemPreview() {
    KohleKompassTheme {
        AddItem(
            focusManager = LocalFocusManager.current,
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
            context = LocalContext.current,
            scope = rememberCoroutineScope(),
            selectedPage = remember { mutableStateOf(0) }
        )
    }
}