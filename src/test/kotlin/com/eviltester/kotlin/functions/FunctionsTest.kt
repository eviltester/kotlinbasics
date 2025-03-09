package com.eviltester.kotlin.functions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionsTest {


    // like most languages the implementation code can be added in a block {...}
    fun sumEvenValuesInAList(ints: List<Int>) : Int {
        return ints.filter { it.mod(2) == 0 }.sum()
    }

    // single line functions do not need the block container
    fun add1ToEveryInt(ints: List<Int>): List<Int> = ints.map { it + 1 }

    // functions can take functions as arguments
    fun printEveryResult(aFunction: () -> List<Int>): List<Int> {
        val results = aFunction()
        results.forEach { println(it) }
        return results
    }

    @Test
    fun `functions can be used as parameters to other functions`() {

        val originalInts = listOf(1, 2, 3, 4, 5, 6)
        val expectedInts = listOf(2, 3, 4, 5, 6, 7)

        assertThat(sumEvenValuesInAList(originalInts)).isEqualTo(12)

        // as a side effect, all returned ints will also be printed to console
        assertThat(printEveryResult { add1ToEveryInt(originalInts) }).isEqualTo(expectedInts)
    }
}