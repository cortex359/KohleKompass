package de.rwhtaachen.kohlekompass.data

import de.rwthaachen.kohlekompass.R

/**
 * A user represents a person using the app. A user can perform actions on the
 * data set. Transactions can be associated with users.
 * The "selected" attribute is used in the UI. It is not to be used by the Model.
 */
data class User(
    // val id: Int,
    val name: String,
    var selected: Boolean = false,
    val profilePicture : Int = R.drawable.baseline_person_outline_24
    //var groups: Collection<Group>,
)

data class Group(
    val id: Int,
    var name: String,
    var admin: User = User("root"),
)