package com.eviltester.leetexercises.algorithms.sums.twoSumsIntArrayNoErrorHandling

class SummingImplementation {

    fun twoSums(inputs: IntArray, totalToFind: Int): IntArray {

        inputs.forEachIndexed { outerIndex, outerInt ->
            inputs.forEachIndexed { innerIndex, innerInt ->
                if(outerIndex != innerIndex){
                    if(outerInt + innerInt == totalToFind){
                        return arrayOf(outerIndex, innerIndex).toIntArray()
                    }
                }
            }
        }

        return emptyArray<Int>().toIntArray()
    }

}
