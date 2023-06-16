package datastructure.section5_introduction

import kotlin.math.pow

fun main() {
    printSmallNumber()
    printLargeNumber()
}

fun printSmallNumber(){
    println(2.0.pow(1000.0)) // Printing it fine
}

fun printLargeNumber(){
    println(6.0.pow(10000.0)) // Infinity error
}