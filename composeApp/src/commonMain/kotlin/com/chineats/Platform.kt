package com.chineats

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform