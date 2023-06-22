package de.rwhtaachen.kohlekompass.advancedSearch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.data.Money
import de.rwhtaachen.kohlekompass.data.SavedSearch
import de.rwhtaachen.kohlekompass.data.User
import de.rwhtaachen.kohlekompass.data.source.example.savedSearches
import de.rwhtaachen.kohlekompass.data.source.example.userList
import kotlin.random.Random


/**
 * Manages the users. Can add and remove users and provide a list of users to the UI.
 */
class UserManager {

    // todo in production the userList is private and can only be accessed through this class. In testing the list from example Data is used
    // private val userList = mutableListOf<Tag>()
    companion object { // equivalent to static from java

        fun getMutableStateUserList(): MutableList<MutableState<User>> {
            return userList.map { user -> mutableStateOf(user.copy(selected = false)) }
                .toMutableStateList()
        }

        fun getUserList(): List<User> {
            return userList
        }

        // todo in production, this should return the actual current unser
        fun getCurrentUser(): User {
            return userList[0]
        }
    }
}

/**
 * Manages the saved searches
 */
class SavedSearchManager {
    companion object {
        //private val savedSearches = mutableSetOf<SavedAdvancedSearch>() todo

        fun addSavedSearch(search: SavedSearch) {
            savedSearches.add(search)
            // todo
        }

        fun removeSavedSearch(search: SavedSearch) {
            savedSearches.remove(search)
            // todo
        }

        fun getSavedSearches(): List<SavedSearch> {
            // todo
            return savedSearches.toList()
        }

        fun getMutableSavedSearchesList(): List<MutableState<SavedSearch>> {
            // todo
            return savedSearches.map { mutableStateOf(it) }.toList()
        }

        /**
         * todo
         * Calculates the amount of money each user owes the current user and vice versa, taking into account only the transactions that match the search
         */
        fun calculateAmounts(search: SavedSearch): Map<User, Money> {
            val result = mutableMapOf<User, Money>()
            (if (search.users.isNullOrEmpty()) UserManager.getUserList() else search.users)
                .filter { it.name != UserManager.getCurrentUser().name }
                .forEach {
                    result[it] = Money(if (Random.nextBoolean()) 4200 else -4200)
                }
            return result
        }
    }
}