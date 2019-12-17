package com.easygautam.easymaterialdesign

fun main() {
    val factor = 0.8f / 2.0f

    println(" <!--    DP -->")
    for (i in 0..1000) {
        val values = i * factor
        println("<dimen name=\"_${i}dp\">${values}dp</dimen>")
    }


    println("\n\n\n")
    println(" <!--    SP -->")
    for (i in 0..100) {
        val values = i * factor
        println("<dimen name=\"_${i}sp\">${values}sp</dimen>")
    }
}