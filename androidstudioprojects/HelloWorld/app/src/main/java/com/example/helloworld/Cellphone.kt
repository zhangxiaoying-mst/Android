package com.example.helloworld

data class Cellphone(val brand:String,val price:Double)


fun main()
{
    val cellphone1=Cellphone("Samsung",1299.99)
    val cellphone2=Cellphone("Samsung",1299.99)

    println(cellphone1)
    println("cellphone1 equals cellphone2 "+(cellphone1==cellphone2))
}