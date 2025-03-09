package com.eviltester.leetexercises.algorithms.sums.twoSumsIntArrayNoErrorHandling

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

interface TwoSumsImplementationInterfaceTest {

    /*
        Given an array of ints, and a desired total

        - return an array of ints which are the first found indexes of the values that match the total
        - caller knows what they are doing and there is always a correct combination so no error handling required
        - may not use the same element twice

        This interface test can be used to check multiple implementations
     */

    fun twoSums(inputs: IntArray, totalToFind: Int) : IntArray

    // danger that test above is hard coded to the implementation since it has expectations on the order of the indexes
    // as input: arrayOf(0, 1, 2, 3, 4).toIntArray(), 4  might return different indexes depending on implementation
    // better test would not assert on the order it would repeat the calculation and validate the rules
    // this is a generic test that can be used to test any implementation, other tests are implementation specific
    @ParameterizedTest
    @MethodSource("twoSumInputValuesNoExpectedIndexes")
    fun `combos to explore the output regardless of algo`(inputArray: IntArray, desiredTotal:Int){

        val answer = twoSums(inputArray,desiredTotal)

        assertThat(inputArray[answer[0]] + inputArray[answer[1]]).isEqualTo(desiredTotal)
        assertThat(answer[0]).isNotEqualTo(answer[1])
    }

    companion object {
        @JvmStatic
        fun twoSumInputValuesNoExpectedIndexes(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(1, 2).toIntArray(), 3),
                Arguments.of(arrayOf(0, 4).toIntArray(), 4),
                Arguments.of(arrayOf(-1, 4).toIntArray(), 3), // can handle negative numbers
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