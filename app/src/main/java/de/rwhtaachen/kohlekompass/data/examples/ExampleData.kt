package de.rwhtaachen.kohlekompass.data.examples

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.SavedAdvancedSearch
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.data.User
import de.rwhtaachen.kohlekompass.data.Item
import java.time.LocalDate
import java.time.Month

val tags = mutableMapOf(
    Pair(
        "bills",
        Tag(
            name = "bills",
            keywords = mutableSetOf(
                "bill",
                "payment",
                "utilities",
                "electricity",
                "internet",
                "heating",
                "gez"
            )
        )
    ),
    Pair(
        "dining",
        Tag(name = "dining", keywords = mutableSetOf("restaurant", "café", "dinner", "lunch", "meal"))
    ),
    Pair(
        "entertainment",
        Tag(
            name = "entertainment",
            keywords = mutableSetOf("movie", "tickets", "cinema", "weekend", "event")
        )
    ),
    Pair(
        "fitness",
        Tag(
            name = "fitness",
            keywords = mutableSetOf("gym", "membership", "workout", "exercise", "fitness")
        )
    ),
    Pair(
        "gas",
        Tag(
            name = "gas",
            keywords = mutableSetOf("gasoline", "fuel", "refill", "petrol", "aral", "shell", "agip", "gas")
        )
    ),
    Pair(
        "groceries",
        Tag(
            name = "groceries",
            keywords = mutableSetOf(
                "grocery",
                "supermarket",
                "store",
                "food",
                "shopping",
                "aldi",
                "lidl",
                "kaufland",
                "penny",
                "netto"
            )
        )
    ),
    Pair(
        "personal care",
        Tag(
            name = "personal care",
            keywords = mutableSetOf("haircut", "haircare", "salon", "beauty", "grooming")
        )
    ),
    Pair(
        "rent",
        Tag(name = "rent", keywords = mutableSetOf("rent", "housing", "accommodation", "apartment"))
    ),
    Pair(
        "toiletries",
        Tag(
            name = "toiletries",
            keywords = mutableSetOf(
                "toiletries",
                "personal hygiene",
                "bathroom",
                "essentials",
                "dm",
                "aldi",
                "lidl",
                "kaufland",
                "penny",
                "netto",
                "rossmann"
            )
        )
    ),
    Pair(
        "travel",
        Tag(
            name = "travel",
            keywords = mutableSetOf(
                "travel",
                "trip",
                "vacation",
                "journey",
                "getaway",
                "bus",
                "gasoline",
                "fuel",
                "refill",
                "petrol",
                "aral",
                "shell",
                "agip",
                "gas"
            )
        )
    )
)

val userList = mutableListOf(
    User("Paul"),
    User("Julia"),
    User("Theo"),
    User("Laura"),
)

@RequiresApi(Build.VERSION_CODES.O)
val itemList = listOf(
    Item(
        title = "Grocery shopping",
        amount = "50.25",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "75.60",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 14),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "45.30",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 5),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "30.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 12),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "25.80",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "15.50",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 22),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "90.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 7),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "300.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 10),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "80.25",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 15),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "65.40",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = "35.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 24),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "40.10",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "35.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "22.80",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "18.75",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.30",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "85.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = "20.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "75.80",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "28.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "38.90",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "32.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "23.70",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "65.50",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "95.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 11),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "350.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "85.25",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 23),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.40",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 29),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = "40.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 3),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "42.10",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "55.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "38.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "27.80",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "16.75",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "65.30",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "80.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "320.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "70.80",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JULY, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "25.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JULY, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "40.10",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "35.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "22.80",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "18.75",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.30",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "85.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = "20.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "75.80",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "28.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "38.90",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "32.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "23.70",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "65.50",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "95.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 11),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "350.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "85.25",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 23),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.40",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 29),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = "40.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 3),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "42.10",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "55.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "38.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "27.80",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "16.75",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "65.30",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "80.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "320.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "70.80",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JULY, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "25.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JULY, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "40.10",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "35.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "22.80",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "18.75",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.30",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "85.00",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = "20.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "75.80",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "28.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "38.90",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "32.50",
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "23.70",
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "65.50",
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    )
)


val savedSearches = mutableListOf(
    SavedAdvancedSearch("Monatsabrechnung"),
    SavedAdvancedSearch("Wochenabrechnung"),
    SavedAdvancedSearch("Sprit"),
    SavedAdvancedSearch("Laufende Kosten Quartal")
)