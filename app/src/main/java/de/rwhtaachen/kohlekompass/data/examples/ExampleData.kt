package de.rwhtaachen.kohlekompass.data.examples

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.advancedSearch.Tag
import de.rwhtaachen.kohlekompass.advancedSearch.User
import de.rwhtaachen.kohlekompass.home.Item
import java.time.LocalDate
import java.time.Month

val tags = mutableMapOf(
    Pair(
        "bills",
        Tag(
            name = "bills",
            keywords = setOf(
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
        Tag(name = "dining", keywords = setOf("restaurant", "café", "dinner", "lunch", "meal"))
    ),
    Pair(
        "entertainment",
        Tag(
            name = "entertainment",
            keywords = setOf("movie", "tickets", "cinema", "weekend", "event")
        )
    ),
    Pair(
        "fitness",
        Tag(
            name = "fitness",
            keywords = setOf("gym", "membership", "workout", "exercise", "fitness")
        )
    ),
    Pair(
        "gas",
        Tag(
            name = "gas",
            keywords = setOf("gasoline", "fuel", "refill", "petrol", "aral", "shell", "agip", "gas")
        )
    ),
    Pair(
        "groceries",
        Tag(
            name = "groceries",
            keywords = setOf(
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
            keywords = setOf("haircut", "haircare", "salon", "beauty", "grooming")
        )
    ),
    Pair(
        "rent",
        Tag(name = "rent", keywords = setOf("rent", "housing", "accommodation", "apartment"))
    ),
    Pair(
        "toiletries",
        Tag(
            name = "toiletries",
            keywords = setOf(
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
            keywords = setOf(
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
        date = LocalDate.of(8, Month.APRIL, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "75.60",
        user = User("Julia"),
        date = LocalDate.of(14, Month.APRIL, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.MAY, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "45.30",
        user = User("Karl"),
        date = LocalDate.of(5, Month.MAY, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "30.00",
        user = User("Paul"),
        date = LocalDate.of(12, Month.MAY, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "25.80",
        user = User("Marie"),
        date = LocalDate.of(18, Month.MAY, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "15.50",
        user = User("Julia"),
        date = LocalDate.of(22, Month.MAY, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(4, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "90.00",
        user = User("Paul"),
        date = LocalDate.of(7, Month.JUNE, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "300.00",
        user = User("Marie"),
        date = LocalDate.of(10, Month.JUNE, 2023),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "80.25",
        user = User("Julia"),
        date = LocalDate.of(15, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "65.40",
        user = User("Karl"),
        date = LocalDate.of(20, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = "35.00",
        user = User("Paul"),
        date = LocalDate.of(24, Month.JUNE, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.APRIL, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "40.10",
        user = User("Karl"),
        date = LocalDate.of(7, Month.APRIL, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(15, Month.APRIL, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "35.50",
        user = User("Paul"),
        date = LocalDate.of(18, Month.APRIL, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "22.80",
        user = User("Marie"),
        date = LocalDate.of(25, Month.APRIL, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "18.75",
        user = User("Julia"),
        date = LocalDate.of(2, Month.MAY, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.30",
        user = User("Karl"),
        date = LocalDate.of(8, Month.MAY, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "85.00",
        user = User("Paul"),
        date = LocalDate.of(13, Month.MAY, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = "20.00",
        user = User("Marie"),
        date = LocalDate.of(21, Month.MAY, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "75.80",
        user = User("Julia"),
        date = LocalDate.of(27, Month.MAY, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "28.50",
        user = User("Paul"),
        date = LocalDate.of(9, Month.JUNE, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.MARCH, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "38.90",
        user = User("Karl"),
        date = LocalDate.of(3, Month.MARCH, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(9, Month.MARCH, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "32.50",
        user = User("Paul"),
        date = LocalDate.of(15, Month.MARCH, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "23.70",
        user = User("Marie"),
        date = LocalDate.of(21, Month.MARCH, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "65.50",
        user = User("Julia"),
        date = LocalDate.of(27, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(4, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "95.00",
        user = User("Paul"),
        date = LocalDate.of(11, Month.JUNE, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "350.00",
        user = User("Marie"),
        date = LocalDate.of(16, Month.JUNE, 2023),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "85.25",
        user = User("Julia"),
        date = LocalDate.of(23, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.40",
        user = User("Karl"),
        date = LocalDate.of(29, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = "40.00",
        user = User("Paul"),
        date = LocalDate.of(3, Month.APRIL, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.MAY, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "42.10",
        user = User("Karl"),
        date = LocalDate.of(7, Month.MAY, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "55.00",
        user = User("Julia"),
        date = LocalDate.of(15, Month.MAY, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "38.50",
        user = User("Paul"),
        date = LocalDate.of(18, Month.MAY, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "27.80",
        user = User("Marie"),
        date = LocalDate.of(25, Month.MAY, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "16.75",
        user = User("Julia"),
        date = LocalDate.of(2, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "65.30",
        user = User("Karl"),
        date = LocalDate.of(8, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "80.00",
        user = User("Paul"),
        date = LocalDate.of(13, Month.JUNE, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "320.00",
        user = User("Marie"),
        date = LocalDate.of(20, Month.JUNE, 2023),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "70.80",
        user = User("Julia"),
        date = LocalDate.of(27, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2, Month.JULY, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "25.50",
        user = User("Paul"),
        date = LocalDate.of(9, Month.JULY, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.APRIL, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "40.10",
        user = User("Karl"),
        date = LocalDate.of(7, Month.APRIL, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(15, Month.APRIL, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "35.50",
        user = User("Paul"),
        date = LocalDate.of(18, Month.APRIL, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "22.80",
        user = User("Marie"),
        date = LocalDate.of(25, Month.APRIL, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "18.75",
        user = User("Julia"),
        date = LocalDate.of(2, Month.MAY, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.30",
        user = User("Karl"),
        date = LocalDate.of(8, Month.MAY, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "85.00",
        user = User("Paul"),
        date = LocalDate.of(13, Month.MAY, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = "20.00",
        user = User("Marie"),
        date = LocalDate.of(21, Month.MAY, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "75.80",
        user = User("Julia"),
        date = LocalDate.of(27, Month.MAY, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "28.50",
        user = User("Paul"),
        date = LocalDate.of(9, Month.JUNE, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.MARCH, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "38.90",
        user = User("Karl"),
        date = LocalDate.of(3, Month.MARCH, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(9, Month.MARCH, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "32.50",
        user = User("Paul"),
        date = LocalDate.of(15, Month.MARCH, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "23.70",
        user = User("Marie"),
        date = LocalDate.of(21, Month.MARCH, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "65.50",
        user = User("Julia"),
        date = LocalDate.of(27, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(4, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "95.00",
        user = User("Paul"),
        date = LocalDate.of(11, Month.JUNE, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "350.00",
        user = User("Marie"),
        date = LocalDate.of(16, Month.JUNE, 2023),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "85.25",
        user = User("Julia"),
        date = LocalDate.of(23, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.40",
        user = User("Karl"),
        date = LocalDate.of(29, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = "40.00",
        user = User("Paul"),
        date = LocalDate.of(3, Month.APRIL, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.MAY, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "42.10",
        user = User("Karl"),
        date = LocalDate.of(7, Month.MAY, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "55.00",
        user = User("Julia"),
        date = LocalDate.of(15, Month.MAY, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "38.50",
        user = User("Paul"),
        date = LocalDate.of(18, Month.MAY, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "27.80",
        user = User("Marie"),
        date = LocalDate.of(25, Month.MAY, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "16.75",
        user = User("Julia"),
        date = LocalDate.of(2, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "65.30",
        user = User("Karl"),
        date = LocalDate.of(8, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "80.00",
        user = User("Paul"),
        date = LocalDate.of(13, Month.JUNE, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = "320.00",
        user = User("Marie"),
        date = LocalDate.of(20, Month.JUNE, 2023),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "70.80",
        user = User("Julia"),
        date = LocalDate.of(27, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2, Month.JULY, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "25.50",
        user = User("Paul"),
        date = LocalDate.of(9, Month.JULY, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.APRIL, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "40.10",
        user = User("Karl"),
        date = LocalDate.of(7, Month.APRIL, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(15, Month.APRIL, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "35.50",
        user = User("Paul"),
        date = LocalDate.of(18, Month.APRIL, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "22.80",
        user = User("Marie"),
        date = LocalDate.of(25, Month.APRIL, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = "18.75",
        user = User("Julia"),
        date = LocalDate.of(2, Month.MAY, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "60.30",
        user = User("Karl"),
        date = LocalDate.of(8, Month.MAY, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = "85.00",
        user = User("Paul"),
        date = LocalDate.of(13, Month.MAY, 2023),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = "20.00",
        user = User("Marie"),
        date = LocalDate.of(21, Month.MAY, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = "75.80",
        user = User("Julia"),
        date = LocalDate.of(27, Month.MAY, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "70.15",
        user = User("Karl"),
        date = LocalDate.of(2, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = "28.50",
        user = User("Paul"),
        date = LocalDate.of(9, Month.JUNE, 2023),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = "1200.00",
        user = User("Marie"),
        date = LocalDate.of(1, Month.MARCH, 2023),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = "38.90",
        user = User("Karl"),
        date = LocalDate.of(3, Month.MARCH, 2023),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = "50.00",
        user = User("Julia"),
        date = LocalDate.of(9, Month.MARCH, 2023),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = "32.50",
        user = User("Paul"),
        date = LocalDate.of(15, Month.MARCH, 2023),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = "23.70",
        user = User("Marie"),
        date = LocalDate.of(21, Month.MARCH, 2023),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = "65.50",
        user = User("Julia"),
        date = LocalDate.of(27, Month.JUNE, 2023),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = "55.75",
        user = User("Karl"),
        date = LocalDate.of(4, Month.JUNE, 2023),
        tags = mutableSetOf(tags["groceries"]!!)
    )
)


val savedSearches = mutableListOf(
    "Monatsabrechnung", "Wochenabrechnung", "Sprit", "Laufende Kosten Quartal"
)