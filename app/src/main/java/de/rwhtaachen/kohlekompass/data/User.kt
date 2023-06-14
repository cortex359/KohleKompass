package de.rwhtaachen.kohlekompass.data

/**
 * A user represents a person using the app. A user can perform actions on the
 * data set. Items can be associated with users.
 * The "selected" attribute is used in the UI. It is not to be used by the Model.
 */
data class User(
    val name: String,
    var selected: Boolean = false
)