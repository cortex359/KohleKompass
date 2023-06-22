package de.rwhtaachen.kohlekompass.manageTags

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import com.google.android.material.snackbar.Snackbar
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.data.source.example.tags
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

/**
 * Manages the tag List. Hands out a fresh copy with all tags unselected to Views
 */
class TagManager {
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

        fun addTag(name: String) {
            val newTag = Tag(name, mutableSetOf())
            tags[newTag.name] = newTag
            GlobalScope.launch(Dispatchers.Default) {
                val genKeywords = getKeywordsFromChatGPT(tagTitle = name, context = context)
                tags[name]!!.keywords.addAll(genKeywords)
                refreshKeywords()
            }
        }

        fun addKeyword(tag: Tag, keyword: String) {
            tag.addKeyword(keyword)
        }

        fun removeKeyword(tag: Tag, keyword: String) {
            tag.removeKeyword(keyword)
        }

        fun updateTagName(tag: Tag, newName: String) {
            val newTag = tag.copy(name = newName)
            tags.remove(tag.name)
            tags[newName] = newTag
        }
    }
}

fun getKeywordsFromChatGPT(tagTitle: String, context: Context): MutableSet<String> {
    val azFunURL = context.resources.getIdentifier(
        "az_fun_url",
        "string",
        context.packageName
    )
    val azFunKey = context.resources.getIdentifier(
        "az_fun_key",
        "string",
        context.packageName
    )
    if (azFunURL == 0 || azFunKey == 0) {
        return mutableSetOf()
    }
    try {
        val url =
            URL("${context.getString(azFunURL)}code=${context.getString(azFunKey)}&name=${tagTitle}")
        val connection = url.openConnection()
        var response = ""
        BufferedReader(InputStreamReader(connection.getInputStream())).use { inp ->
            var line: String?
            while (inp.readLine().also { line = it } != null) {
                response += line
            }
        }
        return response.split(",").toMutableSet()
    } catch (e: Exception) {
        return mutableSetOf()
    }
}