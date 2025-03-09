package com.eviltester.leetexercises.algorithms.totalval.stringmutate

class StringMutatorUsingMapJoinAsStringInterfaceTest: StringAsIntMutateAgainstArrayInterfaceTest {

    override fun maximumNumber(num: String, change: IntArray): String {
        return StringMutator().maximumNumber(num, change)
    }
}