package de.rwhtaachen.kohlekompass.advancedSearch

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwthaachen.kohlekompass.R

@Composable
fun BottomActionBar(context: Context) {
        Row {// ActionRow
            Column(modifier = Modifier.weight(1f)) {
                SaveSearchConfig(context)
            }
            Column {
                CreateDistribution(context = context)
            }
            Column {

            }
        }
}

@Composable
fun SaveSearchConfig(context: Context) {
    Card(
        modifier = Modifier.clickable {

        },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_save_24),
                contentDescription = context.getString(R.string.save_search_config_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp)
            )
            Text(
                text = context.getString(R.string.save_search_config_text),
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Composable
fun CreateDistribution(context: Context) {
    Card(
        modifier = Modifier.clickable {

        },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Icon(
                painter = painterResource(id = R.drawable.baseline_groups_24),
                contentDescription = context.getString(R.string.create_distribution_icon_description),
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp)
            )
            Text(
                text = context.getString(R.string.create_distribution_text),
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Preview
@Composable
fun BottomActionBarPreview() {
    BottomActionBar(context = LocalContext.current)
}