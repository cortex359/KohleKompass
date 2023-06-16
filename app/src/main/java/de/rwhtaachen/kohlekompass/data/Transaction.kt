package de.rwhtaachen.kohlekompass.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

/**
 * An Item is a spending that a user took on a date with an amount.
 * Tags can be associated with an Item
 */
@RequiresApi(Build.VERSION_CODES.O)
data class Transaction(
    val id: Int? = null,
    var title: String = "",
    val description: String = "",
    var user: User,
    var amount: Money = Money(0),
    val recipient: String? = null,
    var value_date: LocalDate,
    var local_date: LocalDate,
    var sync_date: LocalDate?,
    var tags: MutableSet<Tag>
) {
    init {
        this.title = title
        this.user = user
        this.amount = amount
        this.value_date = value_date
        this.sync_date = null
        this.local_date = LocalDate.now()
        this.tags = tags
    }
}