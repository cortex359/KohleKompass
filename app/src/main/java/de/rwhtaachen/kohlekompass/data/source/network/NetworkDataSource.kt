package de.rwhtaachen.kohlekompass.data.source.network

/**
 * Main entry point for accessing tasks data from the network.
 *
 */
interface NetworkDataSource {
    suspend fun loadTasks(): List<NetworkTransaction>
    suspend fun saveTasks(tasks: List<NetworkTransaction>)
}
