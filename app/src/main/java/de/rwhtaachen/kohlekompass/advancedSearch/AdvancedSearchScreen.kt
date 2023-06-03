package de.rwhtaachen.kohlekompass.advancedSearch

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.SearchField
import de.rwhtaachen.kohlekompass.data.examples.tagList
import de.rwhtaachen.kohlekompass.data.examples.userList
import de.rwhtaachen.kohlekompass.home.TopNavBar
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import java.util.Calendar
import java.util.Date


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

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() })
            },
        topBar = {
            TopNavBar(
                searchBarState = mainSearchBarState,
                drawerState = drawerState,
                scope = scope,
                focusManager = focusManager,
                context = context
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
                Row {// Tag and user selection
                    Column(modifier = Modifier.weight(1f)) {// Tag selection
                        TagSelection(tagSearchBarState, focusManager, context)
                    }
                    Column(modifier = Modifier.weight(1f)) {// User selection
                        // empty space to align with tag selection
                        Box(modifier = Modifier.size(40.dp))
                        UserSelection(focusManager, context)
                    }
                }
            }
        }
    )
}

/**
 * Selectable List of all Users
 */
@Composable
private fun UserSelection(
    focusManager: FocusManager,
    context: Context
) {
    LazyColumn(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        items(userList.size) { index ->
            val user = userList[index]
            UserItem(
                remember { mutableStateOf(user) },
                context
            )
        }
    }
}

/**
 * Selectable Card of a user
 */
@Composable
fun UserItem(user: MutableState<User>, context: Context) {
    val colors = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .padding(2.dp)
            .clickable { user.value = User(user.value.name, !user.value.selected) },
        colors = CardDefaults.cardColors(
            containerColor = if (user.value.selected) colors.onSecondaryContainer else colors.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                contentDescription = context.getString(R.string.user_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp),
                tint = if (!user.value.selected) colors.onSecondaryContainer else colors.secondaryContainer
            )
            Text(
                text = user.value.name,
                fontWeight = FontWeight.Bold,
                color = if (!user.value.selected) colors.onSecondaryContainer else colors.secondaryContainer
            )
        }
    }
}

/**
 * Searchable and selectable list of all tags
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TagSelection(
    searchBarState: MutableState<TextFieldValue>,
    focusManager: FocusManager,
    context: Context
) {
    val colors = MaterialTheme.colorScheme
    Card(modifier = Modifier.height(40.dp).padding(2.dp)) {
        SearchField(
            searchBarState = searchBarState, focusManager = focusManager,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = colors.secondaryContainer
            )
        )
    }
    val allSelected = remember { mutableStateOf(false) }
    Card( // (un)select all tags
        modifier = Modifier
            .padding(2.dp)
            .clickable {
                allSelected.value = !allSelected.value; tagList.forEach { tag ->
                tag.selected = allSelected.value
            }
            },
        colors = CardDefaults.cardColors(
            containerColor = if (allSelected.value) colors.onSecondaryContainer else colors.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_checklist_24),
                contentDescription = context.getString(if (!allSelected.value) R.string.select_all_tags else R.string.unselect_all_tags),
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp),
                tint = if (!allSelected.value) colors.onSecondaryContainer else colors.secondaryContainer
            )
            Text(
                text = context.getString(if (!allSelected.value) R.string.select_all_tags else R.string.unselect_all_tags),
                fontWeight = FontWeight.Bold,
                color = if (!allSelected.value) colors.onSecondaryContainer else colors.secondaryContainer
            )
        }
    } // end (un)select all tags
    LazyColumn(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {// todo: make it so selected tags are on top
        items(tagList.size) { index ->
            val tag = tagList[index]
            if (searchBarState.value.text.isEmpty()
                || tag.name.lowercase()
                    .contains(searchBarState.value.text.lowercase())
            ) {
                TagItem(
                    remember { mutableStateOf(tag) },
                    context
                )
            }
        }
    }
}

/**
 * Selectable Card of a tag
 */
@Composable
fun TagItem(tag: MutableState<Tag>, context: Context) {
    val colors = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .padding(2.dp)
            .clickable { tag.value = Tag(tag.value.name, !tag.value.selected) },
        colors = CardDefaults.cardColors(
            containerColor = if (tag.value.selected) colors.onSecondaryContainer else colors.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_sell_24),
                contentDescription = context.getString(R.string.tag_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp),
                tint = if (!tag.value.selected) colors.onSecondaryContainer else colors.secondaryContainer
            )
            Text(
                text = tag.value.name,
                fontWeight = FontWeight.Bold,
                color = if (!tag.value.selected) colors.onSecondaryContainer else colors.secondaryContainer
            )
        }
    }
}

/**
 * Card with a date and a button to open a date picker
 */
@Composable
fun DatePickerCard(
    dateDescription: String,
    defaultText: String,
    date: MutableState<String>
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier= Modifier.fillMaxWidth().padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("$dateDescription ")
            Text(if (date.value == "") defaultText else date.value)
            DatePickerButton(date)
        }
    }
}

/**
 * Button to open a date picker
 */
@Composable
fun DatePickerButton(date: MutableState<String>) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            date.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, year, month, day
    )

    IconButton(onClick = { datePickerDialog.show() }) {
        Icon(
            Icons.Default.DateRange,
            contentDescription = "open menu",
            modifier = Modifier
                .padding(5.dp)
                .size(24.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AdvancedSearchPreview() {
    AdvancedSearch(
        focusManager = LocalFocusManager.current,
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        scope = rememberCoroutineScope(),
        context = LocalContext.current
    )
}

@Preview
@Composable
fun TagSelectionPreview() {
    val searchBarState = remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    TagSelection(searchBarState, focusManager, context)
}