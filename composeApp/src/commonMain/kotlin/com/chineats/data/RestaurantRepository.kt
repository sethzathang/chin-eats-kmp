package com.chineats.data

interface RestaurantRepository {
    suspend fun getNearbyRestaurants(): List<Restaurant>
}

class LocalJsonRestaurantRepository : RestaurantRepository {
    override suspend fun getNearbyRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant(
                id = "1",
                name = "The Rustic Spoon",
                address = "123 Main Street, New York City, NY 208234",
                distanceMeters = 0,
                imageUrl = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?auto=format&fit=crop&w=800&q=80",
                rating = 4.7,
                reviewCount = 500
            ),
            Restaurant(
                id = "2",
                name = "Urban Table",
                address = "456 Market Street, San Francisco, CA 94111",
                distanceMeters = 400,
                imageUrl = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80",
                rating = 4.8,
                reviewCount = 400
            ),
            Restaurant(
                id = "3",
                name = "Bistro 88",
                address = "789 Broadway, Oakland, CA 94607",
                distanceMeters = 600,
                imageUrl = "https://images.unsplash.com/photo-1528605248644-14dd04022da1?auto=format&fit=crop&w=800&q=80",
                rating = 4.8,
                reviewCount = 600
            ),
            Restaurant(
                id = "4",
                name = "Olive & Thyme",
                address = "321 Grove Street, San Jose, CA 95112",
                distanceMeters = 300,
                imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=800&q=80",
                rating = 4.6,
                reviewCount = 300
            ),
            Restaurant(
                id = "5",
                name = "Maple & Ash",
                address = "654 Mission Street, Los Angeles, CA 90017",
                distanceMeters = 200,
                imageUrl = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80",
                rating = 4.7,
                reviewCount = 200
            ),
            Restaurant(
                id = "6",
                name = "The Blue Door",
                address = "987 Howard Street, Seattle, WA 98101",
                distanceMeters = 300,
                imageUrl = "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?auto=format&fit=crop&w=800&q=80",
                rating = 4.9,
                reviewCount = 300
            ),
            Restaurant(
                id = "7",
                name = "Harvest Kitchen",
                address = "159 King Street, Portland, OR 97204",
                distanceMeters = 600,
                imageUrl = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80",
                rating = 4.5,
                reviewCount = 600
            ),
            Restaurant(
                id = "8",
                name = "Firefly Grill",
                address = "753 Castro Street, Austin, TX 78701",
                distanceMeters = 800,
                imageUrl = "https://images.unsplash.com/photo-1502741338009-cac2772e18bc?auto=format&fit=crop&w=800&q=80",
                rating = 4.5,
                reviewCount = 800
            ),
            Restaurant(
                id = "9",
                name = "Red Lantern",
                address = "1010 Pine Street, Denver, CO 80203",
                distanceMeters = 500,
                imageUrl = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80",
                rating = 4.4,
                reviewCount = 210
            ),
            Restaurant(
                id = "10",
                name = "The Greenhouse",
                address = "2020 Market Street, San Francisco, CA 94114",
                distanceMeters = 350,
                imageUrl = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?auto=format&fit=crop&w=800&q=80",
                rating = 4.6,
                reviewCount = 180
            ),
            Restaurant(
                id = "11",
                name = "Sunset Terrace",
                address = "3030 Mission Street, San Francisco, CA 94110",
                distanceMeters = 250,
                imageUrl = "https://images.unsplash.com/photo-1528605248644-14dd04022da1?auto=format&fit=crop&w=800&q=80",
                rating = 4.2,
                reviewCount = 95
            ),
            Restaurant(
                id = "12",
                name = "Cedar & Stone",
                address = "4040 Broadway, New York, NY 10032",
                distanceMeters = 700,
                imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=800&q=80",
                rating = 4.5,
                reviewCount = 130
            ),
            Restaurant(
                id = "13",
                name = "The Golden Hen",
                address = "5050 Sunset Blvd, Los Angeles, CA 90027",
                distanceMeters = 600,
                imageUrl = "https://images.unsplash.com/photo-1432139555190-58524dae6a55?auto=format&fit=crop&w=800&q=80",
                rating = 4.3,
                reviewCount = 110
            ),
            Restaurant(
                id = "14",
                name = "Riverstone Eatery",
                address = "6060 Main Street, Dallas, TX 75201",
                distanceMeters = 800,
                imageUrl = "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?auto=format&fit=crop&w=800&q=80",
                rating = 4.1,
                reviewCount = 75
            ),
            Restaurant(
                id = "15",
                name = "The Copper Pot",
                address = "7070 Elm Street, Chicago, IL 60610",
                distanceMeters = 900,
                imageUrl = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?auto=format&fit=crop&w=800&q=80",
                rating = 4.7,
                reviewCount = 220
            ),
            Restaurant(
                id = "16",
                name = "Saffron Lounge",
                address = "8080 Oak Avenue, Miami, FL 33133",
                distanceMeters = 1000,
                imageUrl = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80",
                rating = 4.6,
                reviewCount = 160
            ),
            Restaurant(
                id = "17",
                name = "The Velvet Room",
                address = "9090 Maple Road, Boston, MA 02118",
                distanceMeters = 1100,
                imageUrl = "https://images.unsplash.com/photo-1528605248644-14dd04022da1?auto=format&fit=crop&w=800&q=80",
                rating = 4.8,
                reviewCount = 250
            ),
            Restaurant(
                id = "18",
                name = "Pearl Street Diner",
                address = "1111 Cedar Lane, Seattle, WA 98121",
                distanceMeters = 1200,
                imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=800&q=80",
                rating = 4.5,
                reviewCount = 140
            )
        )
    }
} 