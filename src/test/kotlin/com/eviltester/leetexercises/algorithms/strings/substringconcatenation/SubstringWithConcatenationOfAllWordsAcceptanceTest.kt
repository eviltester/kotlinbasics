package com.eviltester.leetexercises.algorithms.strings.substringconcatenation

class SubstringWithConcatenationOfAllWordsAcceptanceTest : SubstringWithConcatenationOfAllWordsInterfaceTest {


    override fun findSubstring(s: String, words: Array<String>): List<Int>{
        return SubstringConcatenationChecker().findSubstring(s = s, words = words)
    }

}