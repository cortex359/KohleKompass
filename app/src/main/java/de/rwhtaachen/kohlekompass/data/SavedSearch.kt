package de.rwhtaachen.kohlekompass.data


/**
 * A search configuration saved by the user to be reused later
 * Start delta and end delta are deltas from the current date. So a start delta of -7 and a end delta of 0
 * means all items in the last seven days are included
 */
data class SavedSearch(
    val title: String,
    val query: String? = null,
    val startDelta: Int? = null,
    val endDelta: Int? = null,
    val tags: Set<Tag>? = null,
    val users: Set<User>? = null
)