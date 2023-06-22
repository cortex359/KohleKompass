package de.rwhtaachen.kohlekompass.data

import androidx.compose.ui.text.toLowerCase
import de.rwthaachen.kohlekompass.R

/**
 * Stores a tag with a name, a list of keywords
 * The selected attribute is used in the UI. It is not to be used by the Model.
 * the keywords must all be lowercase!
 */
data class Tag constructor (
    var name: String,
    var keywords: MutableSet<String> = mutableSetOf(),
    var selected: Boolean = false
) {
    init {
        this.changeName(name)
    }

    @Throws(IllegalArgumentException::class)
    @Override
    fun changeName(name: String) {
        if (name.trim().isEmpty())
            throw IllegalArgumentException()
        else
            this.name = name.lowercase()
    }

    fun addKeyword(keyword: String) {
        if (keyword.trim().isEmpty())
            throw IllegalArgumentException()
        else
            this.keywords.add(keyword.lowercase())
    }

    fun removeKeyword(keyword: String) {
        this.keywords.remove(keyword.lowercase())
    }
}