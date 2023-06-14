package de.rwhtaachen.kohlekompass.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import de.rwhtaachen.kohlekompass.ItemNotEditableException
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
) {
    var title: String = title
        set(value) {
            if(this.isEditable.value) {
                field = value
            } else {
                throw ItemNotEditableException("Item is not editable")
            }
        }
    var user: User = user
        set(value) {
            if(this.isEditable.value) {
                field = value
            } else {
                throw ItemNotEditableException("Item is not editable")
            }
        }
    var amount: Int = amount
        set(value) {
            if(this.isEditable.value) {
                field = value
            } else {
                throw ItemNotEditableException("Item is not editable")
            }
        }
    var date: LocalDate = date
        set(value) {
            if(isEditable.value) {
                field = value
            } else {
                throw ItemNotEditableException("Item is not editable")
            }
        }
    val tags: MutableSet<Tag>
    var isEditable : MutableState<Boolean> = mutableStateOf(true)
        get() {
            // todo implement business logic that controls if a tag is editable or not
            // currently all items are editable
            return mutableStateOf(true)
        }
        private set

    init {
        this.title = title
        this.user = user
        this.amount = amount
        this.date = date
        this.tags = tags
    }
}