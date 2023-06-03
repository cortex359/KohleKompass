package de.rwhtaachen.kohlekompass.advancedSearch

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import de.rwhtaachen.kohlekompass.SearchField
import de.rwhtaachen.kohlekompass.data.examples.tagList
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
    val searchBarState = remember { mutableStateOf(TextFieldValue("")) }
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
                searchBarState = searchBarState,
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
                    DatePickerCard(
                        dateDescription = context.getString(R.string.start_date),
                        defaultText = context.getString(R.string.empty_date_format),
                        date = fromDate,
                    )
                    DatePickerCard(
                        dateDescription = context.getString(R.string.end_date),
                        defaultText = context.getString(R.string.today),
                        date = toDate,
                    )
                }
                Row {// Tag and user selection
                    Column {
                        TagSelection(searchBarState, focusManager, context)
                    }
                    Column {// User selection
                        Text("User selection")
                    }
                }
            }
        }
    )
}

@Composable
private fun TagSelection(
    searchBarState: MutableState<TextFieldValue>,
    focusManager: FocusManager,
    context: Context
) {
    SearchField(searchBarState = searchBarState, focusManager = focusManager)
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

@Composable
fun DatePickerCard(
    dateDescription: String,
    defaultText: String,
    date: MutableState<String>
) {
    Card(modifier = Modifier.padding(5.dp)) {
        Row() {
            Column(Modifier.padding(5.dp)) {
                Text("$dateDescription ")
                Text(if (date.value == "") defaultText else date.value)
            }
            Column {
                DatePickerButton(date)
            }
        }
    }
}

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