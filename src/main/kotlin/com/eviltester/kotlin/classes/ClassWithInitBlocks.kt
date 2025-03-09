package com.eviltester.kotlin.classes

class ClassWithInitBlocks(firstname: String, middleName: String = "", surname: String) {

    private var fullName = "$firstname \"$middleName\" $surname"
    private var praised: Boolean = false

    init {
        if (middleName == "Bob") {
            praised = true
            println("Praise $fullName")
        }
    }

    fun getFullName() = fullName
    fun getPraised() = praised

}
