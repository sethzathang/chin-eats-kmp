package com.chineats.data

interface RestaurantRepository {
    suspend fun getNearbyRestaurants(): List<Restaurant>
}

class LocalJsonRestaurantRepository : RestaurantRepository {
    override suspend fun getNearbyRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant(
                "1",
                "Nopa",
                "",
                0,
                "https://images.unsplash.com/photo-1504674900247-0877df9cc836",
                4.7,
                500
            ),
            Restaurant(
                "2",
                "Souvla Hayes Valley",
                "",
                400,
                "https://images.unsplash.com/photo-1526178613658-3f1622045557",
                4.8,
                400
            ),
            Restaurant(
                "3",
                "Little Star Pizza",
                "",
                600,
                "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4",
                4.8,
                600
            ),
            Restaurant(
                "4",
                "Souvla NoPa",
                "",
                300,
                "https://images.unsplash.com/photo-1465101046530-73398c7f28ca",
                4.6,
                300
            ),
            Restaurant(
                "5",
                "Ananda Fuara",
                "",
                200,
                "https://images.unsplash.com/photo-1506744038136-46273834b3fb",
                4.7,
                200
            ),
            Restaurant(
                "6",
                "The Grove",
                "",
                300,
                "https://images.unsplash.com/photo-1465101178521-c1a9136a3b99",
                4.9,
                300
            ),
            Restaurant(
                "7",
                "Souvla Marina",
                "",
                600,
                "https://images.unsplash.com/photo-1504674900247-0877df9cc836",
                4.5,
                600
            ),
            Restaurant(
                "8",
                "Souvla Mission",
                "",
                800,
                "https://images.unsplash.com/photo-1465101046530-73398c7f28ca",
                4.5,
                800
            )
        )
    }
} 