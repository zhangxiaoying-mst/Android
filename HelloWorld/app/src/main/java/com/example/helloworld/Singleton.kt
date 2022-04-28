package com.example.helloworld

object Singleton {
    fun singletonTest(){
        println("singletonTest is called.")
    }
}

fun main(){
    val list= listOf("Apple","Banana","Orange","Pear")

    val lambda={fruit:String->fruit.length}

    val maxLength= list.maxBy {lambda}


}