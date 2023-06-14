package de.rwhtaachen.kohlekompass.data.examples

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.advancedSearch.SavedAdvancedSearch
import de.rwhtaachen.kohlekompass.manageTags.Tag
import de.rwhtaachen.kohlekompass.advancedSearch.User
import de.rwhtaachen.kohlekompass.home.Item
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
val itemList = mutableListOf(
    Item(
        title = "Grocery shopping",
        amount = 5025,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = 7560,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 14),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 4530,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 5),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3000,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 12),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2580,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = 1550,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 22),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 5575,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 9000,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 7),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = 30000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 10),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 8025,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 15),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6540,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = 3500,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 24),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 4010,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5000,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3550,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2280,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = 1875,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6030,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 8500,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = 2000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 7580,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 7015,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = 2850,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 3890,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5000,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3250,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2370,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = 6550,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 5575,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 9500,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 11),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = 35000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 8525,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 23),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6040,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 29),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = 4000,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 3),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 4210,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5500,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3850,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2780,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = 1675,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6530,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 8000,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = 32000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 7080,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 7015,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JULY, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = 2550,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JULY, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 4010,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5000,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3550,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2280,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = 1875,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6030,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 8500,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = 2000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 7580,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 7015,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = 2850,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 3890,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5000,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3250,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2370,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = 6550,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 5575,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 9500,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 11),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = 35000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 8525,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 23),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6040,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 29),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircut",
        amount = 4000,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 3),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 4210,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5500,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3850,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2780,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = 1675,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6530,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 8000,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend getaway",
        amount = 32000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["travel"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 7080,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 7015,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JULY, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = 2550,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JULY, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 4010,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5000,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3550,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2280,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Lunch at a café",
        amount = 1875,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 6030,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Utility bill",
        amount = 8500,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Item(
        title = "Weekend movie marathon",
        amount = 2000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Dinner at a restaurant",
        amount = 7580,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 7015,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Item(
        title = "Haircare products",
        amount = 2850,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Item(
        title = "Monthly rent",
        amount = 120000,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Item(
        title = "Gasoline refill",
        amount = 3890,
        user = User("Karl"),
        date = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Item(
        title = "Gym membership",
        amount = 5000,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Item(
        title = "Movie tickets",
        amount = 3250,
        user = User("Paul"),
        date = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Item(
        title = "Toiletries shopping",
        amount = 2370,
        user = User("Marie"),
        date = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Item(
        title = "Dinner with friends",
        amount = 6550,
        user = User("Julia"),
        date = LocalDate.of(2023, Month.JUNE, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Item(
        title = "Grocery shopping",
        amount = 5575,
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