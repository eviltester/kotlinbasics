package com.eviltester.leetexercises.algorithms.sums.twoSumsIntArrayNoErrorHandling

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TwoSumsTddTest {

    /*
        Given an array of ints, and a desired total

        - return an array of ints which are the first found indexes of the values that match the total
        - caller knows what they are doing and there is always a correct combination so no error handling required
        - may not use the same element twice

        Notes:

        - Original exercise found at https://leetcode.com/problems/two-sum/
     */

    val summer = SummingImplementation()

    // used to get the method signatures correct
    @Test
    fun simpleExampleNoLoopingRequired(){

        val inputArray = arrayOf(1,2).toIntArray()
        val desiredTotal = 3

        val answer = summer.twoSums(inputArray,desiredTotal)

        // originally asserted assertThat(answer).isEqualTo(arrayOf(0,1).toIntArray()) but that enforced an order
        // so amended to... to allow indexes in any order and be less dependent on algorithm
        assertThat(answer).contains(0)
        assertThat(answer).contains(1)
    }

    // this test triggered the implementation of an algorithm rather than return a single hard coded result array
    @Test
    fun `array with three items to require looping`(){
        val inputArray = arrayOf(1, 2, 3).toIntArray()
        val desiredTotal = 5

        val answer = summer.twoSums(inputArray,desiredTotal)

        assertThat(answer).contains(1)
        assertThat(answer).contains(2)
    }

    @Test
    fun `can handle array with same values on different indexes`(){
        val inputArray = arrayOf(2, 1, 2).toIntArray()
        val desiredTotal = 4

        val answer = summer.twoSums(inputArray,desiredTotal)

        assertThat(answer).contains(0)
        assertThat(answer).contains(2)
    }

    // parameterized test allowed checking multiple values
    @ParameterizedTest
    @MethodSource("twoSumInputValues")
    fun `combinations to explore the output`(inputArray: IntArray, desiredTotal:Int, expectedIndexes: IntArray){

        val answer = summer.twoSums(inputArray,desiredTotal)

        assertThat(answer).contains(expectedIndexes[0])
        assertThat(answer).contains(expectedIndexes[1])

    }

    // danger that test above is hard coded to the implementation since it has expectations on the order of the indexes
    // as input: arrayOf(0, 1, 2, 3, 4).toIntArray(), 4  might return different indexes depending on implementation
    // better test would not assert on the order it would repeat the calculation and validate the rules
    // this is a generic test that can be used to test any implementation, other tests are implementation specific
    // Note: Expanded this approach as TwoSumsGenericTest
    @ParameterizedTest
    @MethodSource("twoSumInputValuesNoExpectedIndexes")
    fun `combos to explore the output regardless of algo`(inputArray: IntArray, desiredTotal:Int){

        val answer = summer.twoSums(inputArray,desiredTotal)

        assertThat(inputArray[answer[0]] + inputArray[answer[1]]).isEqualTo(desiredTotal)
        assertThat(answer[0]).isNotEqualTo(answer[1])
    }


    companion object {
        @JvmStatic
        fun twoSumInputValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(1, 2, 3).toIntArray(), 5, arrayOf(1, 2).toIntArray()),
                Arguments.of(arrayOf(1, 2, 3).toIntArray(), 4, arrayOf(0, 2).toIntArray()),
                Arguments.of(arrayOf(1, 2, 3).toIntArray(), 3, arrayOf(0, 1).toIntArray()),
                Arguments.of(arrayOf(1, 2, 3, 4).toIntArray(), 5, arrayOf(0, 3).toIntArray()),
                Arguments.of(arrayOf(1, 2, 3, 4).toIntArray(), 6, arrayOf(1, 3).toIntArray()),
                Arguments.of(arrayOf(0, 1, 2, 3, 4).toIntArray(), 4, arrayOf(0, 4).toIntArray()),
            )
        }

        @JvmStatic
        fun twoSumInputValuesNoExpectedIndexes(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(1, 2, 3).toIntArray(), 5),
                Arguments.of(arrayOf(1, 2, 3).toIntArray(), 4),
                Arguments.of(arrayOf(1, 2, 3).toIntArray(), 3),
                Arguments.of(arrayOf(1, 2, 3, 4).toIntArray(), 5),
                Arguments.of(arrayOf(1, 2, 3, 4).toIntArray(), 6),
                Arguments.of(arrayOf(0, 1, 2, 3, 4).toIntArray(), 4), // multiple possible answers 0,4 and 1,3
                Arguments.of(arrayOf(2, 6, 2, 3, 4).toIntArray(), 4), // repeated values, on different indexes
            )
        }
    }
}