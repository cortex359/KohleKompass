package de.rwhtaachen.kohlekompass.home

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.source.example.itemList
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.manageTags.TagManager

class ItemManager {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun addItem(item: Transaction) {
            itemList.add(item)
            // todo
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun removeItem(item: Transaction) {
            itemList.remove(item)
            // todo
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun updateItem(oldItem: Transaction, newItem: Transaction) {
            val item = itemList[itemList.indexOf(oldItem)]
            item.title = newItem.title
            item.user = newItem.user
            item.amount = newItem.amount
            item.value_date = newItem.value_date
            TagManager.getTagList().forEach { tag ->
                if (newItem.tags.any { tag.value.name == it.name }) {
                    item.tags.add(tag.value)
                } else {
                    item.tags.remove(tag.value)
                }
            }
        }

        /**
         * fetches the items from the database
         * todo
         */
        @RequiresApi(Build.VERSION_CODES.O)
        fun getItemList(): MutableList<MutableState<Transaction>> {
            // todo
            return itemList.map { item -> mutableStateOf(item) }
                .toMutableStateList()
        }
    }
}

/**
 * The value returned by this is shown on the home screen in the bottom bar.
 * This could be e.g. the amount the current user is due to pay to the other users or something similar
 */
fun getAmountDue(): String {
    return "42.42€"
}