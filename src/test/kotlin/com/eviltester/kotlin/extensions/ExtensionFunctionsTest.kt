package com.eviltester.kotlin.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private fun String.removeSpaces() = this.trim().filterNot { it == ' ' }

class ExtensionFunctionsTest {

    @Test
    fun `we can add static extension methods to anything`(){

        val aString = " A    string with   spaces   "
        assertThat(aString.removeSpaces()).isEqualTo("Astringwithspaces")
    }
}