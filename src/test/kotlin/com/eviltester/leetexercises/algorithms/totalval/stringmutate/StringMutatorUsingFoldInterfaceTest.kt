package com.eviltester.leetexercises.algorithms.totalval.stringmutate

class StringMutatorUsingFoldInterfaceTest : StringAsIntMutateAgainstArrayInterfaceTest {

    override fun maximumNumber(num: String, change: IntArray): String {
        return StringMutatorWithFold().maximumNumber(num, change)
    }
}