package com.eviltester.kotlin.classes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BasicClassTest {


    @Test
    fun `can create a class with no constructor params`(){
        val constructedWithNoParams = ReturnBoolean()

        assertThat(constructedWithNoParams.returnTrue()).isTrue()

        // Kotlin idiomatic style is to use property access syntax
        assertThat(constructedWithNoParams.returnTrue()).isTrue
    }

    @Test
    fun `methods can be written as direct statements`(){
        val constructedWithNoParams = ReturnBoolean()

        assertThat(constructedWithNoParams.returnFalse()).isFalse
    }


    @Test
    fun `return value types can be inferred`(){
        val constructedWithNoParams = ReturnBoolean()

        assertThat(constructedWithNoParams.returnFalseInferredType()).isFalse
    }


}