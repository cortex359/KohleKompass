package de.rwhtaachen.kohlekompass.manageTags

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
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
import androidx.compose.ui.window.Dialog
import de.rwhtaachen.kohlekompass.AutoScalingText
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageTags(
    context: Context,
    drawerState: DrawerState,
    scope: CoroutineScope,
    focusManager: FocusManager
) {
    val tags = remember { mutableStateOf(TagManager.getTagList()) }
    val colors = MaterialTheme.colorScheme
    val showEditTagDialog = remember { mutableStateOf(false) }
    val currentTag = remember { mutableStateOf<Tag?>(null) }
    val addTagTextField = remember { mutableStateOf(TextFieldValue("")) }

    if (showEditTagDialog.value) {
        EditTagDialog(
            setShowDialog = {
                showEditTagDialog.value = it
                tags.value = TagManager.getTagList()
            },
            tag = currentTag.value!!,
            context = context,
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = context.getString(R.string.tags_page_title),
                            color = colors.primary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(weight = 1f, fill = true),
                            textAlign = TextAlign.Center
                        )
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = context.getString(R.string.open_menu),
                            tint = Color.Transparent,
                            modifier = Modifier.padding(5.dp)
                        )
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
        content = { _ ->
            Column {
                LazyColumn(
                    Modifier
                        .padding(20.dp)
                        .weight(1f, true)
                ) {
                    items(tags.value.size) {
                        val tag = tags.value[it]
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .clickable() {
                                    currentTag.value = tag.value
                                    showEditTagDialog.value = true
                                },
                            colors = CardDefaults.cardColors(containerColor = colors.primaryContainer),
                            border = BorderStroke(width = 1.dp, color = colors.onPrimaryContainer)
                        ) {
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.outline_sell_24),
                                    contentDescription = context.getString(R.string.tag_icon_description),
                                    modifier = Modifier.padding(5.dp),
                                )
                                Text(
                                    tag.value.name.replaceFirstChar { it.titlecase(Locale.getDefault()) },
                                    modifier = Modifier.padding(5.dp),
                                    fontWeight = FontWeight.Bold
                                )
                                LazyRow(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .weight(1f, true)
                                ) {
                                    items(tag.value.keywords.size) {
                                        val keyword = tag.value.keywords.toList()[it]
                                        Text(keyword + if (it < tag.value.keywords.size - 1) ", " else "")
                                    }
                                }
                                Icon(
                                    Icons.Default.Delete,
                                    context.getString(R.string.delete_icon_description),
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .clickable {
                                            TagManager.deleteTag(tag.value)
                                            tags.value = TagManager.getTagList()
                                        },
                                    tint = colors.error,
                                )
                            }
                        }
                    }
                }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp, 0.dp, 40.dp, 10.dp)
                        .border(
                            BorderStroke(
                                width = 1.dp,
                                color = colors.onSecondaryContainer
                            ),
                            shape = RoundedCornerShape(50)
                        ),
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colors.secondaryContainer,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    value = addTagTextField.value,
                    onValueChange = { value ->
                        addTagTextField.value = value
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Add,
                            context.getString(R.string.add_icon_description),
                            modifier = Modifier
                                .padding(5.dp)
                                .clickable {
                                    TagManager.addTag(addTagTextField.value.text)
                                    tags.value = TagManager.getTagList()
                                    addTagTextField.value = TextFieldValue("")
                                    focusManager.clearFocus()
                                },
                            tint = colors.onSecondaryContainer,
                        )
                    },
                    placeholder = {
                        Text(
                            context.getString(R.string.add_tag_placeholder),
                            color = colors.onSecondaryContainer
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                )

            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTagDialog(
    setShowDialog: (Boolean) -> Unit,
    tag: Tag,
    context: Context,
) {
    val colors = MaterialTheme.colorScheme
    val tagNameField = remember { mutableStateOf(TextFieldValue(tag.name)) }
    val addKeywordField = remember { mutableStateOf(TextFieldValue("")) }
    val keywords = remember { tag.keywords.toMutableStateList() }

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = colors.surface,
        ) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = context.getString(R.string.edit_tag_dialog_title) + " \"" + tag.name + "\"",
                            color = colors.primary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(5.dp),
                            fontSize = 20.sp
                        )
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = context.getString(R.string.close_icon_description),
                            tint = colors.primary,
                            modifier = Modifier.clickable { setShowDialog(false) }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
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
                            shape = RoundedCornerShape(50),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = colors.onPrimary,
                                containerColor = colors.primary,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            value = tagNameField.value,
                            onValueChange = {
                                tagNameField.value = it
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.height(200.dp)) {
                        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
                            items(keywords.size) {
                                Card(
                                    modifier = Modifier.padding(5.dp),
                                    border = BorderStroke(1.dp, colors.onSecondaryContainer),
                                    colors = CardDefaults.cardColors(containerColor = colors.secondaryContainer)
                                ) {
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        val keyword = keywords[it]
                                        AutoScalingText(
                                            text = keyword,
                                            color = colors.onSecondaryContainer,
                                            modifier = Modifier
                                                .padding(5.dp)
                                                .weight(1f, true)
                                        )
                                        Icon(
                                            Icons.Default.Delete,
                                            context.getString(R.string.delete_icon_description),
                                            modifier = Modifier
                                                .padding(5.dp)
                                                .clickable {
                                                    TagManager.removeKeyword(tag, keyword)
                                                    keywords.remove(keyword)
                                                },
                                            tint = colors.onSecondaryContainer,
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(40.dp, 0.dp, 40.dp, 10.dp)
                                .border(
                                    BorderStroke(
                                        width = 1.dp,
                                        color = colors.onSecondaryContainer
                                    ),
                                    shape = RoundedCornerShape(50)
                                ),
                            shape = MaterialTheme.shapes.extraLarge,
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colors.secondaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            value = addKeywordField.value,
                            onValueChange = { value ->
                                addKeywordField.value = value
                            },
                            trailingIcon = {
                                Icon(
                                    Icons.Default.Add,
                                    context.getString(R.string.add_icon_description),
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .clickable {
                                            TagManager.addKeyword(tag, addKeywordField.value.text)
                                            keywords.add(addKeywordField.value.text)
                                            addKeywordField.value = TextFieldValue("")
                                        },
                                    tint = colors.onSecondaryContainer,
                                )
                            },
                            placeholder = {
                                Text(
                                    context.getString(R.string.add_keyword_placeholder),
                                    color = colors.onSecondaryContainer
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Button(
                            onClick = {
                                TagManager.updateTagName(tag, tagNameField.value.text)
                                setShowDialog(false)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    BorderStroke(
                                        width = 1.dp,
                                        color = colors.onPrimary
                                    ),
                                    shape = RoundedCornerShape(50)
                                ),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colors.primary,
                                contentColor = colors.onPrimary
                            )
                        ) {
                            Text(
                                context.getString(R.string.submit_tag_edit_button_text),
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ManageTagsPreview() {
    KohleKompassTheme {
        ManageTags(
            context = LocalContext.current,
            drawerState = rememberDrawerState(
                initialValue = DrawerValue.Closed
            ),
            scope = rememberCoroutineScope(),
            focusManager = LocalFocusManager.current
        )
    }
}

@Preview
@Composable
fun EditTagDialogPreview() {
    KohleKompassTheme {
        EditTagDialog(
            setShowDialog = {},
            tag = Tag(
                "Test",
                mutableSetOf(
                    "Test1",
                    "Test2",
                    "Test3",
                    "Test4",
                    "Test5",
                    "Test6",
                    "Test7",
                    "Test8",
                    "Test9"
                )
            ),
            context = LocalContext.current,
        )
    }
}