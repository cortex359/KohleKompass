package de.rwhtaachen.kohlekompass.data

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
        require(name.trim().isNotEmpty()) // throws IllegalArgumentException if false
        this.name = name.lowercase()
    }

    fun addKeyword(keyword: String) {
        require(keyword.trim().isNotEmpty()) // throws IllegalArgumentException if false
        this.keywords.add(keyword.lowercase())
    }

    fun removeKeyword(keyword: String) {
        this.keywords.remove(keyword.lowercase())
    }
}