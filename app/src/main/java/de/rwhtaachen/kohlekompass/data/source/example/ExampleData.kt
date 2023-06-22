package de.rwhtaachen.kohlekompass.data.source.example

import de.rwhtaachen.kohlekompass.data.Money
import de.rwhtaachen.kohlekompass.data.SavedSearch
import de.rwhtaachen.kohlekompass.data.Tag
import de.rwhtaachen.kohlekompass.data.Transaction
import de.rwhtaachen.kohlekompass.data.User
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
        "entertainment",
        Tag(
            name = "entertainment",
            keywords = mutableSetOf("movie", "tickets", "cinema", "weekend", "event")
        )
    ),
    Pair(
        "subscription",
        Tag(
            name = "subscription",
            keywords = mutableSetOf("subscription","monthly","yearly","billing","fee","payment","service","netflix","spotify","amazon","prime","apple music","dropbox","icloud","office 365","adobe creative cloud","google drive","google one","linkedin premium","audible")
        )
    ),
    Pair(
        "education",
        Tag(
            name = "education",
            keywords = mutableSetOf(
                "education",
                "school",
                "university",
                "college",
                "course",
                "online",
                "certificate",
                "training",
                "learning",
                "teacher",
                "student",
                "book",
                "study",
                "academy",
                "lecture",
                "program",
                "degree",
                "academic",
                "skill",
                "development"
            )
        )
    ),
    Pair(
        "gas",
        Tag(
            name = "gas",
            keywords = mutableSetOf(
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
        "rent",
        Tag(name = "rent", keywords = mutableSetOf("rent", "housing", "accommodation", "apartment"))
    ),
    Pair(
        "laundry",
        Tag(
            name = "laundry",
            keywords = mutableSetOf(
                "laundry",
                "washing",
                "cleaning",
                "laundromat",
                "dry cleaning",
                "ironing",
                "laundry service",
                "laundry room",
                "washer",
                "spin dryer"
            )
        )
    ),
    Pair(
        "household",
        Tag(
            name = "household",
            keywords = mutableSetOf(
                "household",
                "cleaning",
                "home",
                "domestic",
                "chores",
                "detergent",
                "paper towels",
                "soap",
                "shampoo",
                "conditioner",
                "toilet paper",
                "tissue",
                "towel",
                "kitchenware",
                "utensils",
                "plates",
                "pots",
                "pans",
                "oven",
                "microwave",
                "blender",
                "vacuum cleaner",
                "ironing"
            )
        )
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
)

val userList = mutableListOf(
    User("Paul", profilePicture = R.mipmap.avatar04),
    User("Julia", profilePicture = R.mipmap.avatar01),
    User("Marie", profilePicture = R.mipmap.avatar02),
    User("Karl", profilePicture = R.mipmap.avatar03)
)

val transactionList = mutableListOf(
    Transaction(
        title = "Aldi",
        amount = Money(50.25),
        user = userList[1],
        value_date = LocalDate.of(2023, Month.APRIL, 8),
        local_date = LocalDate.of(2023, Month.APRIL, 8),
        sync_date = LocalDate.of(2023, Month.APRIL, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Rent",
        amount = Money(1200.00),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.MAY, 1),
        local_date = LocalDate.of(2023, Month.MAY, 1),
        sync_date = LocalDate.of(2023, Month.MAY, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gas",
        amount = Money(45.30),
        user = userList[3],
        value_date = LocalDate.of(2023, Month.MAY, 5),
        local_date = LocalDate.of(2023, Month.MAY, 5),
        sync_date = LocalDate.of(2023, Month.MAY, 5),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Movie tickets",
        amount = Money(30.00),
        user = userList[0],
        value_date = LocalDate.of(2023, Month.MAY, 12),
        local_date = LocalDate.of(2023, Month.MAY, 12),
        sync_date = LocalDate.of(2023, Month.MAY, 12),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "DM",
        amount = Money(25.80),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.MAY, 18),
        local_date = LocalDate.of(2023, Month.MAY, 18),
        sync_date = LocalDate.of(2023, Month.MAY, 18),
        tags = mutableSetOf(tags["toiletries"]!!)
    ), Transaction(
        title = "Lidl",
        amount = Money(55.75),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.JUNE, 4),
        local_date = LocalDate.of(2023, Month.JUNE, 4),
        sync_date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(90.00),
        user = userList[0],
        value_date = LocalDate.of(2023, Month.JUNE, 7),
        local_date = LocalDate.of(2023, Month.JUNE, 7),
        sync_date = LocalDate.of(2023, Month.JUNE, 7),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Ponte",
        amount = Money(80.25),
        user = userList[1],
        value_date = LocalDate.of(2023, Month.JUNE, 15),
        local_date = LocalDate.of(2023, Month.JUNE, 15),
        sync_date = LocalDate.of(2023, Month.JUNE, 15),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Kaufland",
        amount = Money(65.40),
        user = userList[3],
        value_date = LocalDate.of(2023, Month.JUNE, 20),
        local_date = LocalDate.of(2023, Month.JUNE, 20),
        sync_date = LocalDate.of(2023, Month.JUNE, 20),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "rent",
        amount = Money(1200.00),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.APRIL, 1),
        local_date = LocalDate.of(2023, Month.APRIL, 1),
        sync_date = LocalDate.of(2023, Month.APRIL, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gas",
        amount = Money(40.10),
        user = userList[3],
        value_date = LocalDate.of(2023, Month.APRIL, 7),
        local_date = LocalDate.of(2023, Month.APRIL, 7),
        sync_date = LocalDate.of(2023, Month.APRIL, 7),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Groceries",
        amount = Money(60.30),
        user = userList[3],
        value_date = LocalDate.of(2023, Month.MAY, 8),
        local_date = LocalDate.of(2023, Month.MAY, 8),
        sync_date = LocalDate.of(2023, Month.MAY, 8),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(85.00),
        user = userList[0],
        value_date = LocalDate.of(2023, Month.MAY, 13),
        local_date = LocalDate.of(2023, Month.MAY, 13),
        sync_date = LocalDate.of(2023, Month.MAY, 13),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Movie night",
        amount = Money(20.00),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.MAY, 21),
        local_date = LocalDate.of(2023, Month.MAY, 21),
        sync_date = LocalDate.of(2023, Month.MAY, 21),
        tags = mutableSetOf(tags["entertainment"]!!)
    ), Transaction(
        title = "Cleaning Supplies",
        amount = Money(28.50),
        user = userList[0],
        value_date = LocalDate.of(2023, Month.JUNE, 9),
        local_date = LocalDate.of(2023, Month.JUNE, 9),
        sync_date = LocalDate.of(2023, Month.JUNE, 9),
        tags = mutableSetOf(tags["household"]!!)
    ), Transaction(
        title = "Rent",
        amount = Money(1200.00),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.MARCH, 1),
        local_date = LocalDate.of(2023, Month.MARCH, 1),
        sync_date = LocalDate.of(2023, Month.MARCH, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Rent",
        amount = Money(1200.00),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.JUNE, 1),
        local_date = LocalDate.of(2023, Month.JUNE, 1),
        sync_date = LocalDate.of(2023, Month.JUNE, 1),
        tags = mutableSetOf(tags["rent"]!!)
    ), Transaction(
        title = "Gasoline refill",
        amount = Money(38.90),
        user = userList[3],
        value_date = LocalDate.of(2023, Month.MARCH, 3),
        local_date = LocalDate.of(2023, Month.MARCH, 3),
        sync_date = LocalDate.of(2023, Month.MARCH, 3),
        tags = mutableSetOf(tags["gas"]!!)
    ), Transaction(
        title = "Penny",
        amount = Money(55.75),
        user = userList[3],
        value_date = LocalDate.of(2023, Month.JUNE, 4),
        local_date = LocalDate.of(2023, Month.JUNE, 4),
        sync_date = LocalDate.of(2023, Month.JUNE, 4),
        tags = mutableSetOf(tags["groceries"]!!)
    ), Transaction(
        title = "Utility bill",
        amount = Money(95.00),
        user = userList[0],
        value_date = LocalDate.of(2023, Month.JUNE, 11),
        local_date = LocalDate.of(2023, Month.JUNE, 11),
        sync_date = LocalDate.of(2023, Month.JUNE, 11),
        tags = mutableSetOf(tags["bills"]!!)
    ), Transaction(
        title = "Grocery shopping",
        amount = Money(60.40),
        user = userList[1],
        value_date = LocalDate.of(2023, Month.JUNE, 29),
        local_date = LocalDate.of(2023, Month.JUNE, 29),
        sync_date = LocalDate.of(2023, Month.JUNE, 29),
        tags = mutableSetOf(tags["groceries"]!!)
    ),
    Transaction(
        title = "Textbooks",
        amount = Money(150.00),
        user = userList[1],
        value_date = LocalDate.of(2023, Month.JUNE, 5),
        local_date = LocalDate.of(2023, Month.JUNE, 5),
        sync_date = LocalDate.of(2023, Month.JUNE, 5),
        tags = mutableSetOf(tags["education"]!!)
    ),
    Transaction(
        title = "Pizza delivery",
        amount = Money(25.50),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.JUNE, 7),
        local_date = LocalDate.of(2023, Month.JUNE, 7),
        sync_date = LocalDate.of(2023, Month.JUNE, 7),
        tags = mutableSetOf(tags["entertainment"]!!)
    ),
    Transaction(
        title = "Electricity bill",
        amount = Money(120.00),
        user = userList[2],
        value_date = LocalDate.of(2023, Month.JUNE, 30),
        local_date = LocalDate.of(2023, Month.JUNE, 30),
        sync_date = LocalDate.of(2023, Month.JUNE, 30),
        tags = mutableSetOf(tags["bills"]!!)
    ),
    Transaction(
        title = "Laundry ",
        amount = Money(12.50),
        user = userList[1],
        value_date = (LocalDate.of(2023, Month.APRIL, 19)),
        local_date = (LocalDate.of(2023, Month.APRIL, 19)),
        sync_date = (LocalDate.of(2023, Month.APRIL, 19)),
        tags = mutableSetOf(tags["laundry"]!!)
    ),
    Transaction(
        title = "Netflix ",
        amount = Money(15.0),
        user = userList[2],
        value_date = (LocalDate.of(2023, Month.JUNE, 4)),
        local_date = (LocalDate.of(2023, Month.JUNE, 4)),
        sync_date = (LocalDate.of(2023, Month.JUNE, 4)),
        tags = mutableSetOf(tags["entertainment"]!!, tags["subscription"]!!)
    ),
    Transaction(
        title = "Groceries for party",
        amount = Money(100),
        user = userList[0],
        value_date = (LocalDate.of(2023, Month.MAY, 7)),
        local_date = (LocalDate.of(2023, Month.MAY, 7)),
        sync_date = (LocalDate.of(2023, Month.MAY, 7)),
        tags = mutableSetOf(tags["groceries"]!!, tags["entertainment"]!!)
    )
)

val savedSearches = mutableListOf(
    SavedSearch("Monatsabrechnung"),
    SavedSearch("Wochenabrechnung"),
    SavedSearch("Sprit"),
    SavedSearch("Laufende Kosten Quartal")
)

