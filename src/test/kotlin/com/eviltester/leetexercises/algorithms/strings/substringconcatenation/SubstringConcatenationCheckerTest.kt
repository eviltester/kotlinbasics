package com.eviltester.leetexercises.algorithms.strings.substringconcatenation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SubstringConcatenationCheckerTest {

    @Test
    fun splitIntoWordsOf4Length(){

        assertThat("1234abcd6789efgh".splitByWordLength(wordLength = 4)).
        containsExactly(
            "1234","abcd","6789","efgh"
        )
    }

    @Test
    fun splitIntoWordsOf4LengthTooShort(){

        assertThat("1234abcd6789efg".splitByWordLength(wordLength = 4)).
        containsExactly(
            "1234","abcd","6789","efg"
        )
    }

    @Test
    fun `contains checks for duplicates`(){
        assertThat(listOf("word","good","best","good").containsAllIndividually(listOf("good","good", "best", "word"))).isTrue
    }
}