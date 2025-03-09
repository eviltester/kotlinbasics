package com.eviltester.leetexercises.algorithms.median.twoIntArrays

class MediaArrayCombiner {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        val combo = (nums1 + nums2).sorted() //.toIntArray()

       return if(combo.size % 2 == 0){
            // if even combine two mid values
            val index = (combo.size/2)-1
           (combo[index].toDouble() + combo[index+1].toDouble())/2.00
        }else{
            // if odd take the mid value
            val index = combo.size/2
            combo[index].toDouble()
        }
    }
}