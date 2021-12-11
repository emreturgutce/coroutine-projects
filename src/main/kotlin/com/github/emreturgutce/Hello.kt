package com.github.emreturgutce

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    val scope = CoroutineScope(Dispatchers.Default)
    val start = System.currentTimeMillis()

    fun showSomeData(scope: CoroutineScope) = scope.launch {
        delay(500)
        val end = System.currentTimeMillis()
        println("Thread: ${Thread.currentThread().name} Time: ${end.minus(start)}ms")
    }

    val jobs = mutableListOf<Job>()

    repeat(100) {
        val job = showSomeData(scope)
        jobs.add(job)
    }

    jobs.forEach { it.join() }
}
