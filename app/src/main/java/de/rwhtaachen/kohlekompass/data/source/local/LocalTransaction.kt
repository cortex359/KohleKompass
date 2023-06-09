package de.rwhtaachen.kohlekompass.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Internal model used to represent a transaction stored locally in a Room database.
 * [Data Layer]
 */
@Entity(
    tableName = "transactions"
)
data class LocalTransaction(
    @PrimaryKey val id: Int,
    var title: String,
    var description: String,
    val user: Int,
    val group: Int,
    val amount: Double,
    val recipient: String,
)
