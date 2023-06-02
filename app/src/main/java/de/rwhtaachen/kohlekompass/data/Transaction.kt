package de.rwhtaachen.kohlekompass.data

data class Transaction(
    val id: Int,
    val title: String = "",
    val description: String = "",
    val user: Int,
    val amount: Double = 0.0,
    val recipient: String,
) {

}
