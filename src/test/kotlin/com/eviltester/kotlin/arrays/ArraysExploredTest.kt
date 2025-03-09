package com.eviltester.kotlin.arrays

import io.github.oshai.kotlinlogging.KotlinLogging.logger
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class ArraysExploredTest {

    val log = logger {}

    @Test
    fun `an array can be instantiated with values`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        assertThat(arrayOfInts.size).isEqualTo(4)

        assertThat(arrayOfInts).containsExactly(1, 2, 3, 4)
    }

    @Test
    fun `an array can be instantiated with an initializer lamda`(){
        val arrayOfInts = Array<Int>(4, {it -> it*2})

        assertThat(arrayOfInts.size).isEqualTo(4)
        assertThat(arrayOfInts).containsExactly(0, 2, 4, 6)
    }

    @Test
    fun `array values can be accessed via index starting at 0`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        assertThat(arrayOfInts[0]).isEqualTo(1)
        assertThat(arrayOfInts[1]).isEqualTo(2)
        assertThat(arrayOfInts[2]).isEqualTo(3)
        assertThat(arrayOfInts[3]).isEqualTo(4)

    }

    @Test
    fun `array contents can be modified but an array cannot be expanded in size`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        arrayOfInts[0] = 9

        assertThat(arrayOfInts).containsExactly(9, 2, 3, 4)
    }

    @Test
    fun `arrays can be converted to lists easily`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        val list = arrayOfInts.toList() // or toMutableList

        assertThat(list).containsExactlyInAnyOrder(4, 3, 2, 1)
    }

    @Test
    fun `arrays can be converted to sets easily`(){
        val arrayOfInts = arrayOf(1, 2, 2, 3)

        val set = arrayOfInts.toSet()

        assertThat(set).hasSize(3)
        assertThat(set).containsExactlyInAnyOrder(3, 2, 1)
    }


    @Test
    fun `arrays can be iterated over with forEach`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        var totalForEach = 0

        arrayOfInts.forEach { totalForEach+= it }


        assertThat(totalForEach).isEqualTo(10)
    }

    @Test
    fun `arrays can be iterated over with for in`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        var totalForIn = 0

        for(value in arrayOfInts){
            totalForIn += value
        }

        assertThat(totalForIn).isEqualTo(10)
    }

    @Test
    fun `arrays can be iterated over with forEachIndexed`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        var totalForEachIndexed = 0

        arrayOfInts.forEachIndexed { index, i ->
            log.info { "Summing $i at index $index" }
            totalForEachIndexed += i
        }

        assertThat(totalForEachIndexed).isEqualTo(10)
    }

    @Test
    fun `arrays can be iterated over with map to create a list`(){
        val arrayOfInts = arrayOf(1, 2, 3, 4)

        val alist = arrayOfInts.map { i -> i*2 }

        alist.containsAll(listOf(2, 4, 6, 8))
    }

}