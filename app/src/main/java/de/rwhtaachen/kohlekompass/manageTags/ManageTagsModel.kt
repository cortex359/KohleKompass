package de.rwhtaachen.kohlekompass.manageTags

/**
 * Stores a tag with a name, a list of keywords
 * The selected attribute is used in the UI. It is not to be used by the Model.
 * the keywords must all be lowercase!
 */
data class Tag(val name: String, val keywords: MutableSet<String>, var selected: Boolean = false)