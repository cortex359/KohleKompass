package de.rwhtaachen.kohlekompass.advancedSearch

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar
import java.util.Date

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("$dateDescription ", fontWeight = FontWeight.Bold)
            Text(if (date.value == "") defaultText else date.value, fontWeight = FontWeight.Bold)
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

@Preview
@Composable
fun DatePickerCardPreview() {
    DatePickerCard(
        dateDescription = "From",
        defaultText = "DD/MM/YYYY",
        date = remember { mutableStateOf("") })
}