package com.eviltester.kotlin.conditionals

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConditionalConstructsTest {

    private fun gtLtEqUsingIfThenElse(testVal: Int, againstVal: Int): String {

        if (testVal < againstVal) {
            return "Less Than"
        } else {
            if (testVal > againstVal) {
                return "Greater Than"
            } else {
                return "Equal"
            }
        }
    }

    private fun gtLtEqUsingWhen(testVal: Int, againstVal: Int): String {

        // as a statement control block
        when {
            testVal > againstVal -> return "Greater Than"
            testVal < againstVal -> return "Less Than"
            else -> return "Equal"
        }
    }

    // as an expression which returns a value
    private fun gtLtEqUsingWhenAsExpression(testVal: Int, againstVal: Int): String {
        return when {
            testVal > againstVal -> "Greater Than"
            testVal < againstVal -> "Less Than"
            else -> "Equal"
        }
    }

    // as an expression which returns a value assigned to something else
    private fun gtLtEqUsingWhenAsExpressionInline(testVal: Int, againstVal: Int): String =
        when {
            testVal > againstVal -> "Greater Than"
            testVal < againstVal -> "Less Than"
            else -> "Equal"
        }


    // as an expression which returns a value assigned to something else
    private fun gtLtEqUsingIfThenElseInline(testVal: Int, againstVal: Int): String =
        if (testVal < againstVal) {
            "Less Than"
        } else if (testVal > againstVal) {
            "Greater Than"
        } else {
            "Equal"
        }


    @Test
    fun `if then else`() {
        // normal if then else is available
        assertThat(gtLtEqUsingIfThenElse(10, 15)).isEqualTo("Less Than")
        assertThat(gtLtEqUsingIfThenElse(10, 10)).isEqualTo("Equal")
        assertThat(gtLtEqUsingIfThenElse(15, 10)).isEqualTo("Greater Than")
    }

    @Test
    fun `when`() {
        // normal if then else is available
        assertThat(gtLtEqUsingWhen(10, 15)).isEqualTo("Less Than")
        assertThat(gtLtEqUsingWhen(10, 10)).isEqualTo("Equal")
        assertThat(gtLtEqUsingWhen(15, 10)).isEqualTo("Greater Than")
    }

    @Test
    fun `conditionals can be used as statements`() {
        // normal if then else is available
        assertThat(gtLtEqUsingWhenAsExpression(10, 15)).isEqualTo("Less Than")
        assertThat(gtLtEqUsingWhenAsExpression(10, 10)).isEqualTo("Equal")
        assertThat(gtLtEqUsingWhenAsExpression(15, 10)).isEqualTo("Greater Than")
    }

    @Test
    fun `conditionals can be used as inline statements`() {
        // normal if then else is available
        assertThat(gtLtEqUsingWhenAsExpressionInline(10, 15)).isEqualTo("Less Than")
        assertThat(gtLtEqUsingWhenAsExpressionInline(10, 10)).isEqualTo("Equal")
        assertThat(gtLtEqUsingWhenAsExpressionInline(15, 10)).isEqualTo("Greater Than")
    }

    @Test
    fun `if then else as inline statement`() {
        // normal if then else is available
        assertThat(gtLtEqUsingIfThenElseInline(10, 15)).isEqualTo("Less Than")
        assertThat(gtLtEqUsingIfThenElseInline(10, 10)).isEqualTo("Equal")
        assertThat(gtLtEqUsingIfThenElseInline(15, 10)).isEqualTo("Greater Than")
    }
}