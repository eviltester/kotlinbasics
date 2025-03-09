package com.eviltester.junit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class KotlinExampleTest {

    // methods are functions in Kotlin
    @Test
    fun `Kotlin test names can use string literals with spaces`() {

        // Kotlin does not need semi-colons at the end of lines
        assertThat(true).isTrue()
    }

    @ParameterizedTest
    @MethodSource("dataForTest")
    fun `params are a stream of Arguments`(aString:String, aLength:Int){
        assertThat(aString).hasSize(aLength)
    }

    companion object {
        @JvmStatic
        fun dataForTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("",0),
                Arguments.of("a", 1),
                Arguments.of("ab", 2),
                Arguments.of("1234567890", 10)
            )
        }
    }
}