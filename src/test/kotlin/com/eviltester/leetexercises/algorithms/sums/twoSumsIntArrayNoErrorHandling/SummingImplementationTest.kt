package com.eviltester.leetexercises.algorithms.sums.twoSumsIntArrayNoErrorHandling

class SummingImplementationTest: TwoSumsImplementationInterfaceTest {

    /*
        Given an array of ints, and a desired total

        - return an array of ints which are the first found indexes of the values that match the total
        - caller knows what they are doing and there is always a correct combination so no error handling required
        - may not use the same element twice
     */

    override fun twoSums(inputs: IntArray, totalToFind: Int) : IntArray =
        SummingImplementation().twoSums(inputs, totalToFind)

}