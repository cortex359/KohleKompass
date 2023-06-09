package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import de.rwhtaachen.kohlekompass.advancedSearch.SavedAdvancedSearchManager.Companion.getSavedSearches
import de.rwhtaachen.kohlekompass.cardSelectedColor
import de.rwhtaachen.kohlekompass.data.examples.userList
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R

/**
 * Shows a dialog that shows a textfield for each entry in [fields].
 * The user can enter a value for each field and then press the submit button.
 * The values are then returned to the caller via [setValue].
 * Example:
 * val showDialog =  remember { mutableStateOf(false) }
 * if(showDialog.value)
 *   CustomDialog(..., setShowDialog = {showDialog.value = it}) {
 *   showDialog.value = false
 *   // do something with the values
 * }
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFieldsDialog(
    title: String,
    submitButtonText: String,
    fields: List<String>,
    setShowDialog: (Boolean) -> Unit,
    setValue: (Map<String, String>) -> Unit
) {
    val colors = MaterialTheme.colorScheme
    val results = mutableMapOf<String, String>()

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = colors.surface
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = title, color = colors.onSurface,
                        )
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = colors.onSurface,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    for (field in fields) {
                        val txtField = remember { mutableStateOf("") }
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    BorderStroke(
                                        width = 1.dp,
                                        color = colors.onSurface
                                    ),
                                    shape = RoundedCornerShape(50)
                                ),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            placeholder = { Text(text = field) },
                            value = txtField.value,
                            onValueChange = {
                                txtField.value = it
                                results[field] = it
                            })
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                if (results.values.any { it.isEmpty() } || results.values.any { it.isBlank() } || results.size != fields.size) {
                                    // todo give feedback when not all fields are filled
                                    return@Button
                                }
                                setValue(results)
                                setShowDialog(false)
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = submitButtonText)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun LoadSearchDialog(
    context: Context,
    setShowDialog: (Boolean) -> Unit,
    setValue: (SavedAdvancedSearch) -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = colors.surface
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = context.getString(R.string.load_saved_search_dialog_title),
                            color = colors.onSurface,
                        )
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = colors.onSurface,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    val searches = getSavedSearches()

                    LazyColumn(content = {
                        items(searches.size) { index ->
                            Card(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth()
                                    .clickable { setValue(searches[index]) }
                                    .border(
                                        1.dp,
                                        colors.onPrimaryContainer,
                                        MaterialTheme.shapes.medium
                                    ),
                                colors = CardDefaults.cardColors(
                                    containerColor = colors.primaryContainer
                                )
                            ) {
                                Text(
                                    text = searches[index].title,
                                    fontWeight = FontWeight.Bold,
                                    color = colors.onPrimaryContainer,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    })
                }
            }
        }
    }
}


@Composable
fun DistributeDialog(
    focusManager: FocusManager,
    context: Context,
    users: List<User>,
    setShowDialog: (Boolean) -> Unit,
    setValue: (List<User>) -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = colors.surface
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = context.getString(if (users.isEmpty()) R.string.no_users_selected_error else R.string.create_distribution_dialog_title),
                            color = colors.onSurface,
                        )
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = colors.onSurface,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyColumn(
                        modifier = Modifier
                            .pointerInput(Unit) {
                                detectTapGestures(onTap = {
                                    focusManager.clearFocus()
                                })
                            }
                    ) {
                        items(users.size) { index ->
                            val user = remember { mutableStateOf(users[index]) }
                            Card(
                                modifier = Modifier
                                    .padding(5.dp, 5.dp, 5.dp, 0.dp)
                                    .clickable {
                                        user.value =
                                            user.value.copy(selected = !user.value.selected)
                                    }
                                    .border(
                                        1.dp,
                                        colors.onPrimaryContainer,
                                        MaterialTheme.shapes.medium
                                    ),
                                colors = CardDefaults.cardColors(
                                    containerColor = if (user.value.selected) cardSelectedColor(
                                        colors.primaryContainer
                                    ) else colors.primaryContainer
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
                    }

                    if (users.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(20.dp))

                        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                            Button(
                                onClick = {
                                    setValue(users.filter { it.selected })
                                    setShowDialog(false)
                                },
                                shape = RoundedCornerShape(50.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = context.getString(R.string.submit_distribution_text))
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun InputFieldsDialogPreview() {
    KohleKompassTheme {
        InputFieldsDialog(
            title = "Dialog Preview",
            submitButtonText = "Done",
            fields = listOf("Foo", "Bar"),
            setShowDialog = {},
            setValue = {})
    }
}

@Preview
@Composable
fun LoadSavedSearchPreview() {
    KohleKompassTheme {
        LoadSearchDialog(
            context = LocalContext.current,
            setShowDialog = {},
            setValue = {})
    }
}

@Preview
@Composable
fun DistributeDialogPreview() {
    KohleKompassTheme {
        DistributeDialog(
            focusManager = LocalFocusManager.current,
            context = LocalContext.current,
            users = userList,
            setShowDialog = {},
            setValue = {})
    }
}
