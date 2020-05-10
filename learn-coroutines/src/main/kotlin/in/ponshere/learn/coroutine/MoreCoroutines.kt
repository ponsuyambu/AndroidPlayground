package `in`.ponshere.learn.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    repeat(100_000) { time -> // launch a lot of coroutines
        launch {
            delay(1000L)
            println(time)
        }
    }
}