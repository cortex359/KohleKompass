package de.rwhtaachen.kohlekompass.manageSavedSearches

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.rwhtaachen.kohlekompass.advancedSearch.SavedSearchManager
import de.rwhtaachen.kohlekompass.advancedSearch.UserManager
import de.rwhtaachen.kohlekompass.data.User
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageSavedSearches(
    context: Context,
    drawerState: DrawerState,
    scope: CoroutineScope,
    focusManager: FocusManager
) {
    val savedSearches =
        remember { mutableStateOf(SavedSearchManager.getMutableSavedSearchesList()) }
    val colors = MaterialTheme.colorScheme

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = context.getString(R.string.savedSearches_page_title),
                            color = colors.primary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(weight = 1f, fill = true),
                            textAlign = TextAlign.Center
                        )
                        Column {
                            Text(
                                text = context.getString(R.string.you_owe),
                                color = colors.error,
                                fontSize = 12.sp
                            )
                            Text(
                                text = context.getString(R.string.you_get),
                                color = colors.primary,
                                fontSize = 12.sp
                            )
                        }
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
        content = { padding ->
            Column {
                LazyColumn(
                    Modifier
                        .padding(padding)
                        .weight(1f, true),
                    reverseLayout = true
                ) {
                    items(savedSearches.value.size) { index ->
                        val savedSearch = savedSearches.value[index]
                        val users: List<User> =
                            (if (savedSearch.value.users == null) UserManager.getUserList() else savedSearch.value.users!!)
                                .filter { it.name != UserManager.getCurrentUser().name }.toList()
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = colors.primaryContainer),
                            border = BorderStroke(width = 1.dp, color = colors.onPrimaryContainer)
                        ) {
                            Text(
                                savedSearch.value.title.replaceFirstChar { it.titlecase(Locale.getDefault()) },
                                modifier = Modifier.padding(10.dp),
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                val amounts =
                                    SavedSearchManager.calculateAmounts(savedSearch.value)
                                for (user in users) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Image(
                                            painter = painterResource(id = user.profilePicture),
                                            contentDescription = context.getString(R.string.profile_picture_description),
                                            modifier = Modifier.size(50.dp)
                                        )
                                        Text(
                                            text = user.name,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                        Text(
                                            text = amounts[user].toString(),
                                            color = if (amounts[user].toString()
                                                    .startsWith('-') // todo implement comparators
                                            ) colors.error else colors.primary,
                                            modifier = Modifier.padding(5.dp, 0.dp),
                                        )
                                    }
                                }
                            }
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Card {
                                    Icon(
                                        Icons.Default.Share,
                                        contentDescription = context.getString(R.string.share_icon_description),
                                        Modifier.padding(5.dp)
                                    )
                                }
                                Card(
                                    modifier = Modifier.clickable {
                                        SavedSearchManager.removeSavedSearch(savedSearch.value)
                                        savedSearches.value =
                                            SavedSearchManager.getMutableSavedSearchesList()
                                    },
                                ) {
                                    Icon(
                                        Icons.Default.Delete,
                                        context.getString(R.string.delete_icon_description),
                                        modifier = Modifier.padding(5.dp),
                                        tint = colors.error,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ManageTagsPreview() {
    KohleKompassTheme {
        ManageSavedSearches(
            context = LocalContext.current,
            drawerState = rememberDrawerState(
                initialValue = DrawerValue.Closed
            ),
            scope = rememberCoroutineScope(),
            focusManager = LocalFocusManager.current
        )
    }
}