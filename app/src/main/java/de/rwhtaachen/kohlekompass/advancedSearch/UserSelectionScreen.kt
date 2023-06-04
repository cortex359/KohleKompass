package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.data.examples.userList
import de.rwhtaachen.kohlekompass.ui.theme.cardSelectedColor
import de.rwthaachen.kohlekompass.R


/**
 * Selectable List of all Users
 */
@Composable
fun UserSelection(
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
fun UserItem(user: MutableState<User>, context: Context) {
    val colors = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .padding(5.dp, 5.dp, 5.dp, 0.dp)
            .clickable { user.value = user.value.copy(selected = !user.value.selected) },
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

@Preview
@Composable
fun UserSelectionPreview() {
    UserSelection(focusManager = LocalFocusManager.current, context = LocalContext.current)
}