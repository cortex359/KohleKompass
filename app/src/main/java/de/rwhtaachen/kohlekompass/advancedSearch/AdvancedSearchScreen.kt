package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import de.rwhtaachen.kohlekompass.home.TopNavBar
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedSearch(
    focusManager: FocusManager,
    drawerState: DrawerState,
    scope: CoroutineScope,
    context: Context
) {
    val mainSearchBarState = remember { mutableStateOf(TextFieldValue("")) }
    val tagSearchBarState = remember { mutableStateOf(TextFieldValue("")) }
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
                searchBarState = mainSearchBarState,
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
                    Column(modifier = Modifier.weight(1f)) {// Date selection
                        DatePickerCard(
                            dateDescription = context.getString(R.string.start_date),
                            defaultText = context.getString(R.string.empty_date_format),
                            date = fromDate,
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {// Date selection
                        DatePickerCard(
                            dateDescription = context.getString(R.string.end_date),
                            defaultText = context.getString(R.string.today),
                            date = toDate,
                        )
                    }
                }
                Row {// Tag and user selection
                    Column(modifier = Modifier.weight(1f)) {// Tag selection
                        TagSelection(tagSearchBarState, focusManager, context)
                    }
                    Column(modifier = Modifier.weight(1f)) {// User selection
                        // empty space to align with tag selection
                        UserSelection(focusManager, context)
                    }
                }
                BottomActionBar(context)
            }
        }
    )
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
