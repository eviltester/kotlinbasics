package com.eviltester.kotlin.exceptions

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionsTest {

    @Test
    fun `test for exceptions with assertThrows`(){

        var possibleString : String? = null

        assertThrows<NullPointerException> {
            possibleString!!.length
        }
    }

    @Test
    fun `assert on the exception error message`(){

        val exception = assertThrows<MyCustomException>{
            doSomethingThatThrowsCustomException()
        }

        assertThat(exception.message).isEqualTo("my custom exception message")
    }

    private fun doSomethingThatThrowsCustomException() {
        throw MyCustomException( "my custom exception message")
    }
}