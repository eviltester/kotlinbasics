package com.eviltester.kotlin.strings

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class StringsExploredTest {

    @Test
    fun `String is double quoted`(){

        val string1 = "I am String 1"
        assertThat(string1).isEqualTo("I am String 1")
    }

    @Test
    fun `String can be multi-line`(){
        val multiline = """
            this line has 22 chars
            And this line has 20
        """

        // line breaks and spaces are included
        val lineBreakSize = "\n".length*3
        val indentSize =  "    ".length*(3+3+2)
        assertThat(multiline).hasSize(42 + lineBreakSize + indentSize)
    }

    @Test
    fun `String can be multi-line and trimmed of indented spaces`(){
        val multiline = """
            this line has 22 chars
            And this line has 20
        """.trimIndent()

        assertThat(multiline).hasSize(42 + "\n".length)
    }

    @Test
    fun `Strings can be used as templates using template expressions`(){
        val aValue = 3
        val afterTemplateExpressionExpansion = "$aValue * 2 == ${aValue*2}"

        assertThat(afterTemplateExpressionExpansion).isEqualTo("3 * 2 == 6")
    }
}