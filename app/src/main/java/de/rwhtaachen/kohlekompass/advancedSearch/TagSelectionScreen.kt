package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.SearchField
import de.rwhtaachen.kohlekompass.cardSelectedColor
import de.rwhtaachen.kohlekompass.data.examples.tagList
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R


/**
 * Searchable and selectable list of all tags
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TagSelection(
    searchBarState: MutableState<TextFieldValue>,
    focusManager: FocusManager,
    context: Context
) {
    val colors = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .padding(5.dp, 2.dp)
            .border(1.dp, colors.onPrimaryContainer, MaterialTheme.shapes.large)
    ) {
        SearchField(
            searchBarState = searchBarState, focusManager = focusManager,
            modifier = Modifier
                .border(1.dp, colors.onPrimaryContainer, MaterialTheme.shapes.large)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = colors.primaryContainer,
                focusedLeadingIconColor = colors.onPrimaryContainer,
                unfocusedLeadingIconColor = colors.onPrimaryContainer,
                focusedTrailingIconColor = colors.onPrimaryContainer,
                unfocusedTrailingIconColor = colors.onPrimaryContainer
            )
        )
    }
    val allSelected = remember { mutableStateOf(false) }
    Card( // (un)select all tags
        modifier = Modifier
            .padding(5.dp, 2.dp)
            .clickable {
                allSelected.value = !allSelected.value
                for (i in 0 until tagList.size) {
                    val tag = tagList[i]
                    val newTag = tag.value.copy(selected = allSelected.value)
                    tagList.remove(tag)
                    tagList.add(i, mutableStateOf(newTag))
                }
            }
            .border(1.dp, colors.onPrimaryContainer, MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(
            containerColor = if (allSelected.value) cardSelectedColor(colors.primaryContainer) else colors.primaryContainer
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
                tint = colors.onPrimaryContainer
            )
            Text(
                text = context.getString(if (!allSelected.value) R.string.select_all_tags else R.string.unselect_all_tags),
                fontWeight = FontWeight.Bold,
                color = colors.onPrimaryContainer
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
                || tag.value.name.lowercase().contains(searchBarState.value.text.lowercase())
            ) {
                TagItem(tag, context)
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
            .padding(5.dp, 5.dp, 5.dp, 0.dp)
            .clickable { tag.value = tag.value.copy(selected = !tag.value.selected) }
            .border(1.dp, colors.onPrimaryContainer, MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(
            containerColor = if (tag.value.selected) cardSelectedColor(colors.primaryContainer) else colors.primaryContainer
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
                tint = colors.onPrimaryContainer
            )
            Text(
                text = tag.value.name,
                fontWeight = FontWeight.Bold,
                color = colors.onPrimaryContainer
            )
        }
    }
}


@Preview
@Composable
fun TagSelectionPreview() {
    KohleKompassTheme() {
        val searchBarState = remember { mutableStateOf(TextFieldValue("")) }
        val focusManager = LocalFocusManager.current
        val context = LocalContext.current
        Column {
            TagSelection(searchBarState, focusManager, context)
        }
    }
}