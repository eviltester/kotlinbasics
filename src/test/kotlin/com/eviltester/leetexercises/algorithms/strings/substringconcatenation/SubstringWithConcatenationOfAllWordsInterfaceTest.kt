package com.eviltester.leetexercises.algorithms.strings.substringconcatenation

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

interface SubstringWithConcatenationOfAllWordsInterfaceTest {

    fun findSubstring(s: String, words: Array<String>): List<Int>


    @Test
    fun`foo bar`(){
        assertThat(
            findSubstring( s = "barfoothefoobarman", words = arrayOf("foo","bar")
            )).isEqualTo(listOf(0,9))
    }

    @Test
    fun`wordgoodgoodgoodbestword`(){
        assertThat(
            findSubstring(
                s = "wordgoodgoodgoodbestword",
                words = arrayOf("word","good","best","word")
            )
        ).isEqualTo(emptyList<Int>())
    }

    @Test
    fun`barfoofoobarthefoobarman`(){
        assertThat(
            findSubstring(
                s = "barfoofoobarthefoobarman",
                words = arrayOf("bar","foo","the")
            )
        ).isEqualTo(listOf(6,9,12))
    }

    @Test
    fun`wordgoodgoodgoodbestword at end`(){
        assertThat(
            findSubstring(
                s = "wordgoodgoodgoodbestword",
                words = arrayOf("word","good","best","good")
            )
        ).isEqualTo(listOf(8))
    }
}