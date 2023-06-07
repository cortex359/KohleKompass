package de.rwhtaachen.kohlekompass.advancedSearch

/**
 * Stores a tag with a name, a list of keywords and a boolean to indicate if it is selected
 * the keywords must all be lowercase!
 */
data class Tag(val name: String, var selected: Boolean = false, val keywords: Set<String>)



data class User(val name: String, var selected: Boolean = true)
