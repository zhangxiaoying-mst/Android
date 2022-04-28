package com.example.helloworld

import kotlin.math.max

fun maxvalue(param1:Int,param2:Int)=max(param1,param2)

fun largerNum(num1:Int,num2:Int)=if(num1>num2) num1 else num2

fun score(name:String)=if(name=="Tom"){
    86
}else if(name=="Jim"){
    77
}else if(name=="Jack"){
    95
}else if(name=="Lily"){
    100
}else{
    0
}

fun score1(name:String)=when(name)
{
    "Tom"->86
    "Jim"->77
    else->0
}

fun checkNumber(num:Number){
    when(num){
        is Int ->println("number is Int")
        is Double ->println("number is Double")
        else ->println("number not support")
    }
}


fun main()
{
    val num=10
    val range=10 downTo 1
    for (i in range)
        println(i)

    checkNumber(num)
}