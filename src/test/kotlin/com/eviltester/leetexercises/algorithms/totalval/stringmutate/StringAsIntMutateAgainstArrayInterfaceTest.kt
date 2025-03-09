package com.eviltester.leetexercises.algorithms.totalval.stringmutate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

interface StringAsIntMutateAgainstArrayInterfaceTest {

    /*
        Original exercise - https://leetcode.com/problems/largest-number-after-mutating-substring/

        Given an integer represented as a string
        And a 0-indexed integer array of length 10 that maps each digit 0-9 to another digit.
         e.g. digit d maps to digit change[d]. i.e. 1 -> change[1]

        Choose whether to mutate a single substring of num.
        To mutate a substring, replace each digit num[i] with the digit it maps to in change
         (i.e. replace num[i] with change[num[i]]).

        Return a string representing the largest possible integer after mutating (or choosing not to) a single substring of num.

        A 'single' substring can be mutated and a substring must be contiguous.

     */

    // NOTE: to allow this to be an interface test with method that can be overridden
    fun maximumNumber(num: String, change: IntArray): String

    @Test
    fun `example one from leetcode`(){

        /* Note first example on page is confusing:

        Input: num = "132", change = [9,8,5,0,3,6,4,2,6,8]
        Output: "832"

        Shouldn't this be 835?

        Answer: no, because we are not allowed to change any part of the string, only a substring which is a
        continuous sub string, because we didn't replace 3, we need to stop and it becomes 832
        */

        assertThat(maximumNumber("132", arrayOf(9,8,5,0,3,6,4,2,6,8).toIntArray())).isEqualTo("832")

    }

    @Test
    fun `example two from leetcode`(){
        assertThat(maximumNumber("021", arrayOf(9,4,3,5,7,2,1,9,0,6).toIntArray())).isEqualTo("934")
    }

    @Test
    fun `example three from leetcode`(){
        assertThat(maximumNumber("5", arrayOf(1,4,7,5,3,2,5,6,9,4).toIntArray())).isEqualTo("5")

    }
}