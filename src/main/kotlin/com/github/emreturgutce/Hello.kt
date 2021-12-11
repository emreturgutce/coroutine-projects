package com.github.emreturgutce

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    val request = launch {
        launch(Job()) {
            println("execute independently")
            delay(1000)
            println("not affected")
        }

        launch {
            delay(100)
            println("child of the coroutine")
            delay(1000)
            println("will affect")
        }
    }

    delay(500)
    request.cancel()
    delay(1100)
    println("Finished")
}
