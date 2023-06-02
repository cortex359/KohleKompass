package de.rwhtaachen.kohlekompass.home


data class ListItem(val description: String, val user: String, val amount: String)

// example data
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
