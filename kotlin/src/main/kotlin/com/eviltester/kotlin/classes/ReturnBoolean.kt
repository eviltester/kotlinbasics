package com.eviltester.kotlin.classes

// class has no constructor
class ReturnBoolean {

    // methods are `fun` functions
    fun returnTrue(): Boolean {
        return true
    }

    // methods can be statements
    fun returnFalse(): Boolean = false

    // return vales can be inferred
    fun returnFalseInferredType() = false
}
