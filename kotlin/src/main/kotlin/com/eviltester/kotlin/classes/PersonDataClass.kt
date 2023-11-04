package com.eviltester.kotlin.classes

data class PersonDataClass(val name: String, val age: Int)

class PersonClass(val name: String, val age: Int)


data class PersonDataClassWithAddedFun(val name: String, val age: Int){

    fun isOlderThan(anAge:Int):Boolean = this.age > anAge
}