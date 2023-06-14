package de.rwhtaachen.kohlekompass.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import de.rwhtaachen.kohlekompass.ItemNotEditableException
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
    var amount: Double = 0.0,
    val recipient: String? = null,
    var value_date: LocalDate,
    var local_date: LocalDate,
    var sync_date: LocalDate,
    var tags: MutableSet<Tag>
) {
    init {
        this.title = title
        this.user = user
        this.amount = amount
        this.value_date = value_date
        this.sync_date = LocalDate.now()
        this.local_date = LocalDate.now()
        this.tags = tags
    }
}