package de.rwhtaachen.kohlekompass.home

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.examples.itemList

/**
 * fetches the items from the database
 * todo
 */
@RequiresApi(Build.VERSION_CODES.O)
fun getItems() : List<Item> {
    return itemList
}

/**
 * The value returned by this is shown on the home screen in the bottom bar.
 * This could be e.g. the amount the current user is due to pay to the other users or something similar
 */
fun getAmountDue(): String {
  return "42.42€"
}