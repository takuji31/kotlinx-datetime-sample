package dev.takuji31.kotlinx.datetime

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform