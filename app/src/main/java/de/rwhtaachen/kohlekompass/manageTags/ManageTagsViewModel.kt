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

        fun getMutableTagList(): MutableList<MutableState<Tag>> {
            return tags.values.map { tag -> mutableStateOf(tag.copy(selected = false)) }
                .toMutableStateList()
        }

        fun getTagList(): List<MutableState<Tag>> {
            return tags.values.map { tag -> mutableStateOf(tag.copy(selected = false)) }
                .toList()
        }

        fun deleteTag(tag: Tag) {
            tags.remove(tag.name)
        }

        fun addTag(tag: Tag) {
            tags[tag.name] = tag
        }

        fun addKeyword(tag: Tag, keyword: String) {
            tag.keywords.add(keyword)
        }

        fun removeKeyword(tag: Tag, keyword: String) {
            tag.keywords.remove(keyword)
        }

        fun updateTagName(tag: Tag, newName: String) {
            val newTag = tag.copy(name = newName)
            tags.remove(tag.name)
            tags[newName] = newTag
        }
    }
}