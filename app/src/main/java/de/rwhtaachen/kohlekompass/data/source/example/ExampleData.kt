package de.rwhtaachen.kohlekompass.data.source.example

import android.os.Build
import androidx.annotation.RequiresApi
import de.rwhtaachen.kohlekompass.data.SavedSearch
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.data.User
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.Money
import de.rwthaachen.kohlekompass.R
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
    User("Paul", profilePicture = R.mipmap.avatar04),
    User("Julia", profilePicture = R.mipmap.avatar01),
    User("Marie", profilePicture = R.mipmap.avatar02),
    User("Karl", profilePicture = R.mipmap.avatar03)
)

@RequiresApi(Build.VERSION_CODES.O)
val transactionList = mutableListOf(
    Transaction(
        title = "Grocery shopping",
        amount = Money(50.25),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.APRIL, 8),
        localDate = LocalDate.of(2023, Month.APRIL, 8),
        syncDate = LocalDate.of(2023, Month.APRIL, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Dinner with friends",
        amount = Money(75.60),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.APRIL, 14),
        localDate = LocalDate.of(2023, Month.APRIL, 14),
        syncDate = LocalDate.of(2023, Month.APRIL, 14),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 1),
        localDate = LocalDate.of(2023, Month.MAY, 1),
        syncDate = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(45.30),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MAY, 5),
        localDate = LocalDate.of(2023, Month.MAY, 5),
        syncDate = LocalDate.of(2023, Month.MAY, 5),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(30.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MAY, 12),
        localDate = LocalDate.of(2023, Month.MAY, 12),
        syncDate = LocalDate.of(2023, Month.MAY, 12),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(25.80),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 18),
        localDate = LocalDate.of(2023, Month.MAY, 18),
        syncDate = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Lunch at a café",
        amount = Money(15.50),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 22),
        localDate = LocalDate.of(2023, Month.MAY, 22),
        syncDate = LocalDate.of(2023, Month.MAY, 22),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(55.75),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 4),
        localDate = LocalDate.of(2023, Month.JUNE, 4),
        syncDate = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(90.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 7),
        localDate = LocalDate.of(2023, Month.JUNE, 7),
        syncDate = LocalDate.of(2023, Month.JUNE, 7),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend getaway",
        amount = Money(300.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.JUNE, 10),
        localDate = LocalDate.of(2023, Month.JUNE, 10),
        syncDate = LocalDate.of(2023, Month.JUNE, 10),
        tags = mutableSetOf(tags["travel"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(80.25),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 15),
        localDate = LocalDate.of(2023, Month.JUNE, 15),
        syncDate = LocalDate.of(2023, Month.JUNE, 15),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(65.40),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 20),
        localDate = LocalDate.of(2023, Month.JUNE, 20),
        syncDate = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircut",
        amount = Money(35.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 14),
        localDate = LocalDate.of(2023, Month.JUNE, 14),
        syncDate = LocalDate.of(2023, Month.JUNE, 14),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.APRIL, 1),
        localDate = LocalDate.of(2023, Month.APRIL, 1),
        syncDate = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(40.10),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.APRIL, 7),
        localDate = LocalDate.of(2023, Month.APRIL, 7),
        syncDate = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(50.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.APRIL, 15),
        localDate = LocalDate.of(2023, Month.APRIL, 15),
        syncDate = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(35.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.APRIL, 18),
        localDate = LocalDate.of(2023, Month.APRIL, 18),
        syncDate = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(22.80),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.APRIL, 25),
        localDate = LocalDate.of(2023, Month.APRIL, 25),
        syncDate = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Lunch at a café",
        amount = Money(18.75),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 2),
        localDate = LocalDate.of(2023, Month.MAY, 2),
        syncDate = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(60.30),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MAY, 8),
        localDate = LocalDate.of(2023, Month.MAY, 8),
        syncDate = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(85.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MAY, 13),
        localDate = LocalDate.of(2023, Month.MAY, 13),
        syncDate = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend movie marathon",
        amount = Money(20.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 21),
        localDate = LocalDate.of(2023, Month.MAY, 21),
        syncDate = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(75.80),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 27),
        localDate = LocalDate.of(2023, Month.MAY, 27),
        syncDate = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(70.15),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 2),
        localDate = LocalDate.of(2023, Month.JUNE, 2),
        syncDate = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircare products",
        amount = Money(28.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 9),
        localDate = LocalDate.of(2023, Month.JUNE, 9),
        syncDate = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MARCH, 1),
        localDate = LocalDate.of(2023, Month.MARCH, 1),
        syncDate = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(38.90),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MARCH, 3),
        localDate = LocalDate.of(2023, Month.MARCH, 3),
        syncDate = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(50.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MARCH, 9),
        localDate = LocalDate.of(2023, Month.MARCH, 9),
        syncDate = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(32.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MARCH, 15),
        localDate = LocalDate.of(2023, Month.MARCH, 15),
        syncDate = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(23.70),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MARCH, 21),
        localDate = LocalDate.of(2023, Month.MARCH, 21),
        syncDate = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Dinner with friends",
        amount = Money(65.50),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 20),
        localDate = LocalDate.of(2023, Month.JUNE, 20),
        syncDate = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(55.75),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 4),
        localDate = LocalDate.of(2023, Month.JUNE, 4),
        syncDate = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(95.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 11),
        localDate = LocalDate.of(2023, Month.JUNE, 11),
        syncDate = LocalDate.of(2023, Month.JUNE, 11),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend getaway",
        amount = Money(350.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.JUNE, 16),
        localDate = LocalDate.of(2023, Month.JUNE, 16),
        syncDate = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["travel"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(85.25),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 20),
        localDate = LocalDate.of(2023, Month.JUNE, 20),
        syncDate = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(60.40),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 21),
        localDate = LocalDate.of(2023, Month.JUNE, 21),
        syncDate = LocalDate.of(2023, Month.JUNE, 21),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircut",
        amount = Money(40.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.APRIL, 3),
        localDate = LocalDate.of(2023, Month.APRIL, 3),
        syncDate = LocalDate.of(2023, Month.APRIL, 3),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 1),
        localDate = LocalDate.of(2023, Month.MAY, 1),
        syncDate = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(42.10),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MAY, 7),
        localDate = LocalDate.of(2023, Month.MAY, 7),
        syncDate = LocalDate.of(2023, Month.MAY, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(55.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 15),
        localDate = LocalDate.of(2023, Month.MAY, 15),
        syncDate = LocalDate.of(2023, Month.MAY, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(38.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MAY, 18),
        localDate = LocalDate.of(2023, Month.MAY, 18),
        syncDate = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(27.80),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 25),
        localDate = LocalDate.of(2023, Month.MAY, 25),
        syncDate = LocalDate.of(2023, Month.MAY, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Lunch at a café",
        amount = Money(16.75),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 2),
        localDate = LocalDate.of(2023, Month.JUNE, 2),
        syncDate = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(65.30),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 8),
        localDate = LocalDate.of(2023, Month.JUNE, 8),
        syncDate = LocalDate.of(2023, Month.JUNE, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(80.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 13),
        localDate = LocalDate.of(2023, Month.JUNE, 13),
        syncDate = LocalDate.of(2023, Month.JUNE, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend getaway",
        amount = Money(320.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.JUNE, 20),
        localDate = LocalDate.of(2023, Month.JUNE, 20),
        syncDate = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["travel"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(70.80),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JANUARY, 27),
        localDate = LocalDate.of(2023, Month.JANUARY, 27),
        syncDate = LocalDate.of(2023, Month.JANUARY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(70.15),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JANUARY, 2),
        localDate = LocalDate.of(2023, Month.JANUARY, 2),
        syncDate = LocalDate.of(2023, Month.JANUARY, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircare products",
        amount = Money(25.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JANUARY, 9),
        localDate = LocalDate.of(2023, Month.JANUARY, 9),
        syncDate = LocalDate.of(2023, Month.JANUARY, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.APRIL, 1),
        localDate = LocalDate.of(2023, Month.APRIL, 1),
        syncDate = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(40.10),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.APRIL, 7),
        localDate = LocalDate.of(2023, Month.APRIL, 7),
        syncDate = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(50.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.APRIL, 15),
        localDate = LocalDate.of(2023, Month.APRIL, 15),
        syncDate = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(35.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.APRIL, 18),
        localDate = LocalDate.of(2023, Month.APRIL, 18),
        syncDate = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(22.80),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.APRIL, 25),
        localDate = LocalDate.of(2023, Month.APRIL, 25),
        syncDate = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Lunch at a café",
        amount = Money(18.75),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 2),
        localDate = LocalDate.of(2023, Month.MAY, 2),
        syncDate = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(60.30),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MAY, 8),
        localDate = LocalDate.of(2023, Month.MAY, 8),
        syncDate = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(85.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MAY, 13),
        localDate = LocalDate.of(2023, Month.MAY, 13),
        syncDate = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend movie marathon",
        amount = Money(20.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 21),
        localDate = LocalDate.of(2023, Month.MAY, 21),
        syncDate = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(75.80),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 27),
        localDate = LocalDate.of(2023, Month.MAY, 27),
        syncDate = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(70.15),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 2),
        localDate = LocalDate.of(2023, Month.JUNE, 2),
        syncDate = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircare products",
        amount = Money(28.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 9),
        localDate = LocalDate.of(2023, Month.JUNE, 9),
        syncDate = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MARCH, 1),
        localDate = LocalDate.of(2023, Month.MARCH, 1),
        syncDate = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(38.90),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MARCH, 3),
        localDate = LocalDate.of(2023, Month.MARCH, 3),
        syncDate = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(50.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MARCH, 9),
        localDate = LocalDate.of(2023, Month.MARCH, 9),
        syncDate = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(32.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MARCH, 15),
        localDate = LocalDate.of(2023, Month.MARCH, 15),
        syncDate = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(23.70),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MARCH, 21),
        localDate = LocalDate.of(2023, Month.MARCH, 21),
        syncDate = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Dinner with friends",
        amount = Money(65.50),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 17),
        localDate = LocalDate.of(2023, Month.JUNE, 17),
        syncDate = LocalDate.of(2023, Month.JUNE, 17),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(55.75),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 4),
        localDate = LocalDate.of(2023, Month.JUNE, 4),
        syncDate = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(95.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 11),
        localDate = LocalDate.of(2023, Month.JUNE, 11),
        syncDate = LocalDate.of(2023, Month.JUNE, 11),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend getaway",
        amount = Money(350.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.JUNE, 16),
        localDate = LocalDate.of(2023, Month.JUNE, 16),
        syncDate = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["travel"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(85.25),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 17),
        localDate = LocalDate.of(2023, Month.JUNE, 17),
        syncDate = LocalDate.of(2023, Month.JUNE, 17),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(60.40),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 17),
        localDate = LocalDate.of(2023, Month.JUNE, 17),
        syncDate = LocalDate.of(2023, Month.JUNE, 17),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircut",
        amount = Money(40.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.APRIL, 3),
        localDate = LocalDate.of(2023, Month.APRIL, 3),
        syncDate = LocalDate.of(2023, Month.APRIL, 3),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 1),
        localDate = LocalDate.of(2023, Month.MAY, 1),
        syncDate = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(42.10),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MAY, 7),
        localDate = LocalDate.of(2023, Month.MAY, 7),
        syncDate = LocalDate.of(2023, Month.MAY, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(55.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 15),
        localDate = LocalDate.of(2023, Month.MAY, 15),
        syncDate = LocalDate.of(2023, Month.MAY, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(38.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MAY, 18),
        localDate = LocalDate.of(2023, Month.MAY, 18),
        syncDate = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(27.80),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 25),
        localDate = LocalDate.of(2023, Month.MAY, 25),
        syncDate = LocalDate.of(2023, Month.MAY, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Lunch at a café",
        amount = Money(16.75),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 2),
        localDate = LocalDate.of(2023, Month.JUNE, 2),
        syncDate = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(65.30),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 8),
        localDate = LocalDate.of(2023, Month.JUNE, 8),
        syncDate = LocalDate.of(2023, Month.JUNE, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(80.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 13),
        localDate = LocalDate.of(2023, Month.JUNE, 13),
        syncDate = LocalDate.of(2023, Month.JUNE, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend getaway",
        amount = Money(320.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.JUNE, 20),
        localDate = LocalDate.of(2023, Month.JUNE, 20),
        syncDate = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["travel"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(70.80),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 16),
        localDate = LocalDate.of(2023, Month.JUNE, 16),
        syncDate = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(70.15),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JANUARY, 2),
        localDate = LocalDate.of(2023, Month.JANUARY, 2),
        syncDate = LocalDate.of(2023, Month.JANUARY, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircare products",
        amount = Money(25.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JANUARY, 9),
        localDate = LocalDate.of(2023, Month.JANUARY, 9),
        syncDate = LocalDate.of(2023, Month.JANUARY, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.APRIL, 1),
        localDate = LocalDate.of(2023, Month.APRIL, 1),
        syncDate = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(40.10),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.APRIL, 7),
        localDate = LocalDate.of(2023, Month.APRIL, 7),
        syncDate = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(50.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.APRIL, 15),
        localDate = LocalDate.of(2023, Month.APRIL, 15),
        syncDate = LocalDate.of(2023, Month.APRIL, 15),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(35.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.APRIL, 18),
        localDate = LocalDate.of(2023, Month.APRIL, 18),
        syncDate = LocalDate.of(2023, Month.APRIL, 18),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(22.80),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.APRIL, 25),
        localDate = LocalDate.of(2023, Month.APRIL, 25),
        syncDate = LocalDate.of(2023, Month.APRIL, 25),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Lunch at a café",
        amount = Money(18.75),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 2),
        localDate = LocalDate.of(2023, Month.MAY, 2),
        syncDate = LocalDate.of(2023, Month.MAY, 2),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(60.30),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MAY, 8),
        localDate = LocalDate.of(2023, Month.MAY, 8),
        syncDate = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(85.00),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MAY, 13),
        localDate = LocalDate.of(2023, Month.MAY, 13),
        syncDate = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Weekend movie marathon",
        amount = Money(20.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MAY, 21),
        localDate = LocalDate.of(2023, Month.MAY, 21),
        syncDate = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Dinner at a restaurant",
        amount = Money(75.80),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MAY, 27),
        localDate = LocalDate.of(2023, Month.MAY, 27),
        syncDate = LocalDate.of(2023, Month.MAY, 27),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(70.15),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 2),
        localDate = LocalDate.of(2023, Month.JUNE, 2),
        syncDate = LocalDate.of(2023, Month.JUNE, 2),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Haircare products",
        amount = Money(28.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.JUNE, 9),
        localDate = LocalDate.of(2023, Month.JUNE, 9),
        syncDate = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["personal care"]!!)
    ), Transaction(
        title = "Monthly rent",
        amount = Money(1200.00),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MARCH, 1),
        localDate = LocalDate.of(2023, Month.MARCH, 1),
        syncDate = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(38.90),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.MARCH, 3),
        localDate = LocalDate.of(2023, Month.MARCH, 3),
        syncDate = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Gym membership",
        amount = Money(50.00),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.MARCH, 9),
        localDate = LocalDate.of(2023, Month.MARCH, 9),
        syncDate = LocalDate.of(2023, Month.MARCH, 9),
        tags = mutableSetOf(tags["fitness"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(32.50),
        user = userList[0],
        valueDate = LocalDate.of(2023, Month.MARCH, 15),
        localDate = LocalDate.of(2023, Month.MARCH, 15),
        syncDate = LocalDate.of(2023, Month.MARCH, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Toiletries shopping",
        amount = Money(23.70),
        user = userList[2],
        valueDate = LocalDate.of(2023, Month.MARCH, 21),
        localDate = LocalDate.of(2023, Month.MARCH, 21),
        syncDate = LocalDate.of(2023, Month.MARCH, 21),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Dinner with friends",
        amount = Money(65.50),
        user = userList[1],
        valueDate = LocalDate.of(2023, Month.JUNE, 16),
        localDate = LocalDate.of(2023, Month.JUNE, 16),
        syncDate = LocalDate.of(2023, Month.JUNE, 16),
        tags = mutableSetOf(tags["dining"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(55.75),
        user = userList[3],
        valueDate = LocalDate.of(2023, Month.JUNE, 4),
        localDate = LocalDate.of(2023, Month.JUNE, 4),
        syncDate = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    )
)

val savedSearches = mutableListOf(
    SavedSearch("Monatsabrechnung"),
    SavedSearch("Wochenabrechnung"),
    SavedSearch("Sprit"),
    SavedSearch("Laufende Kosten Quartal")
)

