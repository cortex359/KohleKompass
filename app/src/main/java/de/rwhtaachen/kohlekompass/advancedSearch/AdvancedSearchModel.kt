package de.rwhtaachen.kohlekompass.advancedSearch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.data.examples.tagList
import de.rwhtaachen.kohlekompass.data.examples.userList

/**
 * Stores a tag with a name, a list of keywords and a boolean to indicate if it is selected
 * the keywords must all be lowercase!
 */
data class Tag(val name: String, var selected: Boolean = false, val keywords: Set<String>)

/**
 * Manages the tag List. Hands out a fresh copy with all tags unselected to Views
 */
class TagManager() {

    // todo in production the tagList is private and can only be accessed through this class. In testing the list from example Data is used
    // private val tagList = mutableListOf<Tag>()

    companion object { // equivalent to static from java
        fun getTagList(): MutableList<MutableState<Tag>> {
            return tagList.map { tag -> mutableStateOf(tag.copy(selected = false)) }
                .toMutableStateList()
        }
    }
}

data class User(val name: String, var selected: Boolean = true)

/**
 * Manages the user List. Hands out a fresh copy with all users unselected to Views
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
