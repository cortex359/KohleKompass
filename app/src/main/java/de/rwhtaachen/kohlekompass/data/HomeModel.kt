package de.rwhtaachen.kohlekompass.data

import java.time.LocalDate

/**
 * An Item is a spending that a user took on a date with an amount.
 * Tags can be associated with an Item
 */
data class Item(
    val title: String,
    val user: User,
    val amount: String,
    val date: LocalDate,
    val tags: MutableSet<Tag>
)