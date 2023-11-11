package com.eviltester.kotlin.classes

data class PersonDataClass(val name: String, val age: Int)

class PersonClass(val name: String, val age: Int)


data class PersonDataClassWithAddedFun(val name: String, val age: Int){

    fun isOlderThan(anAge:Int):Boolean = this.age > anAge
}

data class PersonClassImmutability(val name: String, val age: Int){
    // the main attributes are already immutable and can't change
    // so how do we work with the class?

    fun changeName(newName: String): PersonClassImmutability= this.copy(name= newName)
    fun increaseAge(by: Int): PersonClassImmutability= this.copy(age= this.age+by)

}