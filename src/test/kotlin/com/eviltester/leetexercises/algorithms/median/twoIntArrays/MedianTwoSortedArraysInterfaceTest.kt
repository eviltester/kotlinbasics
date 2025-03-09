package com.eviltester.leetexercises.algorithms.median.twoIntArrays

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

interface MedianTwoSortedArraysInterfaceTest {

    /*
        https://leetcode.com/problems/median-of-two-sorted-arrays/description/

        Given two sorted arrays nums1 and nums2 of size m and n respectively,
        return the median of the two sorted arrays.

        Median is the middle value, or middle values /2
     */

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double

    @Test
    fun `example 1`(){

        assertThat(
            findMedianSortedArrays(arrayOf(1,3).toIntArray(), arrayOf(2).toIntArray())).isEqualTo(2.00)

    }

    @Test
    fun `example 2`(){

        assertThat(
            findMedianSortedArrays(arrayOf(1,2).toIntArray(), arrayOf(3,4).toIntArray())).isEqualTo(2.50)

    }

    @Test
    fun `example 3`(){

        assertThat(
            findMedianSortedArrays(arrayOf(2,2,4,4).toIntArray(), arrayOf(2,2,2,4,4).toIntArray())).isEqualTo(2.00)

    }


}