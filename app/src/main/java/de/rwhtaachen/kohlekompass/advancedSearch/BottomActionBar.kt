package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.AutoScalingText
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme
import de.rwthaachen.kohlekompass.R

@Composable
fun BottomActionBar(context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {// ActionRow
        Column(modifier = Modifier.weight(1f)) {
            SaveSearch(context = context)
        }
        Column(modifier = Modifier.weight(1f)) {
            LoadSearch(context = context)
        }
        Column(modifier = Modifier.weight(1f)) {
            CreateDistribution(context = context)
        }
        Column(modifier = Modifier.weight(1f)) {
            SubmitSearch(context = context)
        }
    }
}

@Composable
fun SaveSearch(context: Context) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSecondaryContainer,
                MaterialTheme.shapes.medium
            )
            .clickable {

            },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_save_24),
                contentDescription = context.getString(R.string.save_search_config_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(45.dp)
            )
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center,
            ) {
                AutoScalingText(
                    text = context.getString(R.string.save_search_config_text),
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Composable
fun LoadSearch(context: Context) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSecondaryContainer,
                MaterialTheme.shapes.medium
            )
            .clickable {

            },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_download_24),
                contentDescription = context.getString(R.string.load_search_config_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(45.dp)
            )
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center,
            ) {
                AutoScalingText(
                    text = context.getString(R.string.load_search_config_text),
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Composable
fun CreateDistribution(context: Context) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSecondaryContainer,
                MaterialTheme.shapes.medium
            )
            .clickable {

            },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_groups_24),
                contentDescription = context.getString(R.string.create_distribution_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(45.dp)
            )
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center,
            ) {
                AutoScalingText(
                    text = context.getString(R.string.create_distribution_text),
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Composable
fun SubmitSearch(context: Context) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSecondaryContainer,
                MaterialTheme.shapes.medium
            )
            .clickable {

            },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Default.Search,
                contentDescription = context.getString(R.string.submit_search_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(45.dp)
            )
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center,
            ) {
                AutoScalingText(
                    text = context.getString(R.string.submit_search_text),
                    modifier = Modifier.padding(5.dp),
                )

            }
        }
    }
}

@Preview
@Composable
fun BottomActionBarPreview() {
    KohleKompassTheme() {
        BottomActionBar(context = LocalContext.current)
    }
}