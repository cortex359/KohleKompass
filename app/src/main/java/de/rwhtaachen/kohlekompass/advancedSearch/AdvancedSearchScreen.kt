package de.rwhtaachen.kohlekompass.advancedSearch

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Row( // Date Picker
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    DatePickerCard(
                        dateDescription = context.getString(R.string.start_date),
                        defaultText = context.getString(R.string.empty_date_format),
                        date = fromDate,
                        context = context
                    )
                    DatePickerCard(
                        dateDescription = context.getString(R.string.end_date),
                        defaultText = context.getString(R.string.today),
                        date = toDate,
                        context = context
                    )
                }
                Row() {// Tag and user selection
                    Column() {// Tag selection

                    }
                    Column() {// User selection
                    }
                }
            }
        }
    )
}

@Composable
fun DatePickerCard(dateDescription: String, defaultText: String, date: MutableState<String>, context: Context) {
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