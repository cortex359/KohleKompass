package de.rwhtaachen.kohlekompass.advancedSearch

import de.rwhtaachen.kohlekompass.manageTags.Tag


/**
 * A user represents a person using the app. A user can perform actions on the
 * data set. Items can be associated with users.
 * The "selected" attribute is used in the UI. It is not to be used by the Model.
 */
data class User(val name: String, var selected: Boolean = false)

/**
 * A search configuration saved by the user to be reused later
 * Start delta and end delta are deltas from the current date. So a start delta of -7 and a end delta of 0
 * means all items in the last seven days are included
 */
data class SavedAdvancedSearch(
    val title: String,
    val query: String? = null,
    val startDelta: Int? = null,
    val endDelta: Int? = null,
    val tags: Set<Tag>? = null,
    val users: Set<User>? = null
)