package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.cardSelectedColor
import de.rwhtaachen.kohlekompass.data.User
import de.rwthaachen.kohlekompass.R


/**
 * Selectable List of all Users
 */
@Composable
fun UserSelection(
    focusManager: FocusManager,
    context: Context,
    users: List<MutableState<User>>
) {
    LazyColumn(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        items(users.size) { index ->
            val user = users[index]
            UserTransaction(
                user,
                context
            )
        }
    }
}

/**
 * Selectable Card of a user
 */
@Composable
fun UserTransaction(user: MutableState<User>, context: Context) {
    val colors = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .padding(5.dp, 5.dp, 5.dp, 0.dp)
            .clickable { user.value = user.value.copy(selected = !user.value.selected) }
            .border(1.dp, colors.onPrimaryContainer, MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(
            containerColor = if (user.value.selected) cardSelectedColor(colors.primaryContainer) else colors.primaryContainer
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
                tint = colors.onPrimaryContainer
            )
            Text(
                text = user.value.name,
                fontWeight = FontWeight.Bold,
                color = colors.onPrimaryContainer
            )
        }
    }
}
/*
@Preview
@Composable
fun UserSelectionPreview() {
    KohleKompassTheme() {
        UserSelection(focusManager = LocalFocusManager.current, context = LocalContext.current, users = userList)
    }
}
*/
