package de.rwhtaachen.kohlekompass.data

import java.time.LocalDate

/**
 * An Item is a spending that a user took on a date with an amount.
 * Tags can be associated with an Item
 */
data class Transaction(
    val id: Int? = null,
    val title: String = "",
    val description: String = "",
    val user: User,
    val amount: Double = 0.0,
    val recipient: String? = null,
    val value_date: LocalDate,
    val local_date: LocalDate,
    val sync_date: LocalDate,
    val tags: MutableSet<Tag>
)