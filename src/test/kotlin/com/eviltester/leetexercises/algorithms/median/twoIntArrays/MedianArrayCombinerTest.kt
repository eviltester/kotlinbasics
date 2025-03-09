package com.eviltester.leetexercises.algorithms.median.twoIntArrays

class MedianArrayCombinerTest: MedianTwoSortedArraysInterfaceTest {

    override fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
       return MediaArrayCombiner().findMedianSortedArrays(nums1 = nums1, nums2 = nums2)
    }

}