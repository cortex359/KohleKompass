package de.rwhtaachen.kohlekompass.addItem

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.advancedSearch.DatePickerCard
import de.rwhtaachen.kohlekompass.data.examples.meUser
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItem(focusManager: FocusManager, context: Context, drawerState: DrawerState) {
    val colors = MaterialTheme.colorScheme
    val txtField = remember { mutableStateOf(TextFieldValue("")) }
    val date = remember {
        mutableStateOf(
            LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        )
    }
    val selectedUser = remember { mutableStateOf(meUser) }
    val showSelectUserDialog = remember { mutableStateOf(false) }

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

    Column(modifier = Modifier.padding(20.dp)) {
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
                    if (txtField.value != TextFieldValue("")) {
                        IconButton(
                            onClick = {
                                focusManager.clearFocus()
                                txtField.value = TextFieldValue("")
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = ""
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(50),
                placeholder = { Text("Description", color = colors.onPrimary) },
                value = txtField.value,
                onValueChange = {
                    txtField.value = it
                }
            )
        }
        Row {
            Column(Modifier.weight(1f)) {
                DatePickerCard(
                    dateDescription = "",
                    defaultText = context.getString(R.string.today),
                    date = date
                )
            }
            Column(Modifier.weight(1f)) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showSelectUserDialog.value = true }
                        .padding(5.dp)
                        .border(1.dp, colors.onPrimaryContainer, MaterialTheme.shapes.medium),
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
        }
        Row {
            Card(
                modifier = Modifier.padding(5.dp).fillMaxWidth(),
                border = BorderStroke(1.dp, colors.onPrimaryContainer),
                colors = CardDefaults.cardColors(
                    containerColor = colors.primaryContainer
                )
            ) {
                Column {
                    Row {
                        Text("Suggested Tags:")
                    }
                    Row {

                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AddItemPreview() {
    KohleKompassTheme() {
        AddItem(
            focusManager = LocalFocusManager.current,
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
            context = LocalContext.current
        )
    }
}