package com.example.helloworld

open class Person(val name:String,val age:Int) {

    constructor():this("",0)


    fun eat(){
        println(name+" is eating. He is "+age+" years old.")
    }
}

