package de.rwhtaachen.kohlekompass.advancedSearch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.data.examples.tags
import de.rwhtaachen.kohlekompass.data.examples.userList

/**
 * Stores a tag with a name, a list of keywords
 * The selected attribute is used in the UI. It is not to be used by the Model.
 * the keywords must all be lowercase!
 */
data class Tag(val name: String, val keywords: Set<String>, var selected: Boolean = false)

/**
 * Manages the tag List. Hands out a fresh copy with all tags unselected to Views
 */
class TagManager() {

    // todo in production the tagList is private and fetched from a database and can only be accessed through this class.
    // todo In testing the list from example Data is used
    // private val tagList = mutableListOf<Tag>()

    companion object { // equivalent to static from java
        fun getTagList(): MutableList<MutableState<Tag>> {
            return tags.values.map { tag -> mutableStateOf(tag.copy(selected = false)) }
                .toMutableStateList()
        }
    }
}

/**
 * A user represents a person using the app. A user can perform actions on the
 * data set. Items can be associated with users.
 * The "selected" attribute is used in the UI. It is not to be used by the Model.
 */
data class User(val name: String, var selected: Boolean = false)

/**
 * Manages the users. Can add and remove users and provide a list of users to the UI.
 */
class UserManager() {

    // todo in production the userList is private and can only be accessed through this class. In testing the list from example Data is used
    // private val userList = mutableListOf<Tag>()
    companion object { // equivalent to static from java

        fun getUserList(): MutableList<MutableState<User>> {
            return userList.map { user -> mutableStateOf(user.copy(selected = false)) }
                .toMutableStateList()
        }

        // todo in production, this should return the actual current unser
        fun getCurrentUser(): User {
            return User("Paul")
        }
    }
}
