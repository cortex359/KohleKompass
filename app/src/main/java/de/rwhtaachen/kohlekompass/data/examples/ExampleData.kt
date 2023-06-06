package de.rwhtaachen.kohlekompass.data.examples

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import de.rwhtaachen.kohlekompass.advancedSearch.Tag
import de.rwhtaachen.kohlekompass.advancedSearch.User
import de.rwhtaachen.kohlekompass.home.ListItem

val tagList = mutableStateListOf(
    mutableStateOf(Tag("Groceries")),
    mutableStateOf(Tag("Fuel")),
    mutableStateOf(Tag("Toileteries")),
    mutableStateOf(Tag("Bakery")),
    mutableStateOf(Tag("Party")),
)

val userList = mutableStateListOf(
    mutableStateOf(User("Max")),
    mutableStateOf(User("Julia")),
    mutableStateOf(User("Theo")),
    mutableStateOf(User("Laura")),
)

// currently loggid in user
val meUser = User("Max")

val itemList = listOf(
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Max", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Max", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Max", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
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

val savedSearches = mutableListOf(
    "Monatsabrechnung",
    "Wochenabrechnung",
    "Sprit",
    "Laufende Kosten Quartal"
)