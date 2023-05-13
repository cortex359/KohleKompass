package de.rwhtaachen.kohlekompass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme

data class ListItem(val description: String, val user: String, val amount: String)

val listItems = listOf(
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KohleKompassTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopNavBar()
                }
            }
        }
    }
}


@Composable
fun ContentView() {
    val columnScrollState = rememberScrollState()
    LazyColumn() {
        items(listItems.size) { index ->
            val item = listItems[index]
            val shape = MaterialTheme.shapes.medium
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, shape)
                    .border(1.dp, MaterialTheme.colorScheme.background, shape)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(item.description, style = MaterialTheme.typography.titleMedium)
                        Text(item.user, style = MaterialTheme.typography.titleSmall)
                    }
                    Text(item.amount)
                }
            }
        }
    }
}


@Composable
fun TopNavBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                imageVector = androidx.compose.material.icons.Icons.Default.Menu,
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }

        Box(
            modifier = Modifier
                .weight(3f, true)
                .height(50.dp)
                .background(MaterialTheme.colorScheme.secondary)
        )

        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                imageVector = androidx.compose.material.icons.Icons.Default.Add,
                contentDescription = "Add",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KohleKompassTheme {
        Column() {
            TopNavBar()
            ContentView()
        }
    }
}