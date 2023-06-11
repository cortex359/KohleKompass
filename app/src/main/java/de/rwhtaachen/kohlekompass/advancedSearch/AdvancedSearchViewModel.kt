package de.rwhtaachen.kohlekompass.advancedSearch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.data.examples.savedSearches
import de.rwhtaachen.kohlekompass.data.examples.userList


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

/**
 * Manages the saved searches
 */
class SavedAdvancedSearchManager {
    companion object {
        //private val savedSearches = mutableSetOf<SavedAdvancedSearch>() todo

        fun addSavedSearch(search: SavedAdvancedSearch) {
            savedSearches.add(search)
            // todo
        }

        fun removeSavedSearch(search: SavedAdvancedSearch) {
            savedSearches.remove(search)
            // todo
        }

        fun getSavedSearches() : List<SavedAdvancedSearch> {
            // todo
            return savedSearches.toList()
        }
    }
}