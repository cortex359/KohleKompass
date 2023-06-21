package de.rwhtaachen.kohlekompass.manageTags

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import com.azure.ai.openai.OpenAIClient
import com.azure.ai.openai.OpenAIClientBuilder
import com.azure.ai.openai.models.ChatCompletions
import com.azure.ai.openai.models.ChatCompletionsOptions
import com.azure.ai.openai.models.ChatMessage
import com.azure.ai.openai.models.ChatRole
import com.azure.core.credential.AzureKeyCredential
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.data.source.example.tags
import de.rwthaachen.kohlekompass.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

        fun addTag(name: String, context: Context, scope: CoroutineScope) {
            tags[name] = Tag(name, mutableSetOf())
            scope.launch {
                tags[name]!!.keywords.addAll(getKeywordsFromChatGPT(name, context = context))
            }
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

fun getKeywordsFromChatGPT(tagTitle: String, context: Context): MutableSet<String> {
    val oaiApiKey = context.resources.getIdentifier(
        "oai_api_key",
        "string",
        context.packageName
    )
    val oaiApiEndpoint = context.resources.getIdentifier(
        "oai_endpoint",
        "string",
        context.packageName
    )
    if (oaiApiKey == 0 || oaiApiEndpoint == 0) {
        return mutableSetOf()
    }
    try {
        val client: OpenAIClient = OpenAIClientBuilder()
            .credential(AzureKeyCredential(context.getString(oaiApiKey)))
            .endpoint(context.getString(oaiApiEndpoint))
            .buildClient()

        val chatMessages: MutableList<ChatMessage> = ArrayList()
        chatMessages.add(ChatMessage(ChatRole.SYSTEM).setContent(context.getString(R.string.system_message)))
        chatMessages.add(ChatMessage(ChatRole.USER).setContent(context.getString(R.string.example_user_1)))
        chatMessages.add(ChatMessage(ChatRole.ASSISTANT).setContent(context.getString(R.string.example_assistant_1)))
        chatMessages.add(ChatMessage(ChatRole.USER).setContent(context.getString(R.string.example_user_2)))
        chatMessages.add(ChatMessage(ChatRole.ASSISTANT).setContent(context.getString(R.string.example_assistant_2)))
        chatMessages.add(ChatMessage(ChatRole.USER).setContent(context.getString(R.string.example_user_3)))
        chatMessages.add(ChatMessage(ChatRole.ASSISTANT).setContent(context.getString(R.string.example_assistant_3)))
        chatMessages.add(ChatMessage(ChatRole.USER).setContent(context.getString(R.string.example_user_4)))
        chatMessages.add(ChatMessage(ChatRole.ASSISTANT).setContent(context.getString(R.string.example_assistant_4)))
        chatMessages.add(ChatMessage(ChatRole.USER).setContent(tagTitle))

        val chatCompletions: ChatCompletions = client.getChatCompletions(
            context.getString(R.string.oai_chat_model),
            ChatCompletionsOptions(chatMessages)
        )
        val response = chatCompletions.choices[0].message.content
        return response.split(",").toMutableSet()
    } catch (HttpResponseException: Exception) { // vpn not connected
        return mutableSetOf()
    } catch (e: ExceptionInInitializerError) {
        // todo azure oai api does not work on android although it does in standard kotlin
        return mutableSetOf()
    }
}