package de.rwhtaachen.kohlekompass.manageTags

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import de.rwhtaachen.kohlekompass.data.examples.tags

/**
 * Manages the tag List. Hands out a fresh copy with all tags unselected to Views
 */
class TagManager() {
    companion object { // equivalent to static from java
        // todo in production the tagList is private and fetched from a database and can only be accessed through this class.
        // todo In testing the list from example Data is used
        // private val tagList = mutableListOf<Tag>()

        fun getTagList(): MutableList<MutableState<Tag>> {
            return tags.values.map { tag -> mutableStateOf(tag.copy(selected = false)) }
                .toMutableStateList()
        }
    }
}