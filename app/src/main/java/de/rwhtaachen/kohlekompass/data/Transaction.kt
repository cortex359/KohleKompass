package de.rwhtaachen.kohlekompass.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

/**
 * An Item is a spending that a user took on a date with an amount.
 * Tags can be associated with an Item
 */
@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey
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
        this.sync_date = null
        this.local_date = LocalDate.now()
    }
}