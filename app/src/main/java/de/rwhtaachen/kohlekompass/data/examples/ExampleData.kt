package de.rwhtaachen.kohlekompass.data.examples

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import de.rwhtaachen.kohlekompass.advancedSearch.Tag
import de.rwhtaachen.kohlekompass.advancedSearch.User
import de.rwhtaachen.kohlekompass.home.ListItem

val tagList = mutableStateListOf(
    mutableStateOf(
        Tag(
            "Groceries",
            keywords = setOf(
                "einkaufen",
                "lebensmittel",
                "lidl",
                "aldi",
                "rewe",
                "edeka",
                "kaufland",
                "netto",
                "penny"
            )
        )
    ),
    mutableStateOf(
        Tag(
            "Fuel",
            keywords = setOf(
                "tanken",
                "benzin",
                "sprit",
                "aral",
                "shell",
                "esso",
                "total",
                "jet",
                "omv",
                "agip"
            )
        )
    ),
    mutableStateOf(
        Tag(
            "Toileteries",
            keywords = setOf(
                "dm",
                "rossmann",
                "putzmittel",
                "drogerie",
                "drogeriemarkt",
                "apotheke"
            )
        )
    ),
    mutableStateOf(
        Tag(
            "Bakery",
            keywords = setOf("backwerk", "bäckerei", "bakery", "bäcker", "brötchen", "brot")
        )
    ),
    mutableStateOf(
        Tag(
            "Party",
            keywords = setOf("party", "feier", "snacks", "geburtstag", "geschenk", "geschenke")
        )
    ),
)

val userList = mutableStateListOf(
    mutableStateOf(User("Paul")),
    mutableStateOf(User("Julia")),
    mutableStateOf(User("Theo")),
    mutableStateOf(User("Laura")),
)

// currently loggid in user
val meUser = User("Paul")

val itemList = listOf(
    ListItem("Lidl", "Paul", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Paul", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Paul", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Paul", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Paul", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Paul", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Paul", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Paul", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Paul", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€"),
    ListItem("Lidl", "Paul", "12,34€"),
    ListItem("Aldi", "Laura", "5,60€"),
    ListItem("DM", "Paul", "8,56€"),
    ListItem("Lieferando Pizza Mittwoch", "Paul", "33,67€"),
    ListItem("Aldi", "Laura", "23,45€")
)

val savedSearches = mutableListOf(
    "Monatsabrechnung",
    "Wochenabrechnung",
    "Sprit",
    "Laufende Kosten Quartal"
)