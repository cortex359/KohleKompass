package de.rwhtaachen.kohlekompass.advancedSearch

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
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
    val colors = MaterialTheme.colorScheme
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
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .border(1.dp, colors.onPrimaryContainer, MaterialTheme.shapes.medium)
            .clickable(onClick = { datePickerDialog.show() }),
        colors = CardDefaults.cardColors(
            containerColor = colors.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "$dateDescription ",
                fontWeight = FontWeight.Bold,
                color = colors.onPrimaryContainer
            )
            Text(
                if (date.value == "") defaultText else date.value,
                fontWeight = FontWeight.Bold,
                color = colors.onPrimaryContainer
            )
            Icon(
                Icons.Default.DateRange,
                contentDescription = "open menu",
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp),
                tint = colors.onPrimaryContainer
            )
        }
    }
}

@Preview
@Composable
fun DatePickerCardPreview() {
    KohleKompassTheme() {
        DatePickerCard(
            dateDescription = "From",
            defaultText = "DD/MM/YYYY",
            date = remember { mutableStateOf("") })
    }
}