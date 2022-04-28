package com.example.helloworld

class Student(name:String,age:Int,val sno:String,val grade:Int):
    Person(name,age),Study{

    constructor(name:String,age:Int):this(name,age,"",0)
    constructor():this("",0);

    override fun readBooks() {
        println(name+" is reading.")
    }

}

fun doStudy(study:Study)
{
    study.doHomework()
    study.readBooks()
}

fun main(){
    val std=Student("zhangsan",10,"a123",10)

    val student=Student("Jack",19)

    doStudy(student)

}