package de.rwhtaachen.kohlekompass.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

/**
 * An Transaction is a spending that a user took on a date with an amount.
 * Tags can be associated with an Transaction
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
    var valueDate: LocalDate,
    var localDate: LocalDate,
    var syncDate: LocalDate?,
    var tags: MutableSet<Tag>
) {
    init {
        this.syncDate = null
        this.localDate = LocalDate.now()
    }
}