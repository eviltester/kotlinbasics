package com.eviltester.kotlin.collections.lists

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class ListBasicsTest {

    data class Item(val text: String, val count: Int)

    @Test
    fun `a list can be empty`(){

        val listOfItems : List<Item> = emptyList()

        assertThat(listOfItems).hasSize(0)
        assertThat(listOfItems).isEmpty()

        // Note: a List can not be added to, use a mutableList for that
    }

    @Test
    fun `a mutable list can be added to`(){

        val listOfItems = mutableListOf<Item>()

        listOfItems.add(Item("can of beans", 1))

        assertThat(listOfItems).hasSize(1)
        assertThat(listOfItems).isNotEmpty()
    }


    @Test
    fun `items in a list can be accessed via index`(){

        val listOfItems = listOf(Item("can of beans", 1))

        assertThat(listOfItems[0].text).isEqualTo("can of beans")
    }


    @Test
    fun `lists can be iterated over`(){
        val listOfItems = listOf(
            Item("can of beans", 3),
            Item("bottle of rum", 2),
            Item("a buckle", 1),
            Item("a swash", 4)
        )

        var totalCount = 0
        // forEachIndexed also provides the index of where the item is in the list
        listOfItems.forEach{ item ->
            totalCount += item.count
        }

        assertThat(totalCount).isEqualTo(10)
    }

    @Test
    fun `lists have many methods that act on item properties`(){
        val listOfItems = listOf(
            Item("can of beans", 3),
            Item("bottle of rum", 2),
            Item("a buckle", 1),
            Item("a swash", 4)
        )

        assertThat(listOfItems.sumOf { item -> item.count }).isEqualTo(10)

        // Note: don't actually need the item -> that was added for readability
        assertThat(listOfItems.sumOf { it.count }).isEqualTo(10)
    }

    @Test
    fun `lists can be mapped over to create a list item for each item`(){
        val listOfItems = listOf(
            Item("can of beans", 3),
            Item("bottle of rum", 2),
            Item("a buckle", 1),
            Item("a swash", 4)
        )

        val counts = listOfItems.map{ item -> item.count }

        // counts is now a list of Ints and that has extra methods like sum
        assertThat(counts.sum()).isEqualTo(10)
    }


    // Lists have a lot of built-in methods to sort, filter, group (creates map), etc.
    // check docs or code completion

    @Test
    fun `lists can be sorted`(){
        val listOfItems = listOf(
            Item("can of beans", 3),
            Item("bottle of rum", 2),
            Item("a buckle", 1),
            Item("a swash", 4)
        )

        val sortedList = listOfItems.sortedBy { it.count }

        // other sorts include sortedByDescending and sortedWith comparator

        assertThat(sortedList).containsExactly(
            Item("a buckle", 1),
            Item("bottle of rum", 2),
            Item("can of beans", 3),
            Item("a swash", 4)
        )
    }

    @Test
    fun `lists can be filtered`(){
        val listOfItems = listOf(
            Item("can of beans", 3),
            Item("bottle of rum", 2),
            Item("a buckle", 1),
            Item("a swash", 4)
        )

        val filteredList = listOfItems.filter { it.count > 1 }

        assertThat(filteredList).containsExactly(
            Item("can of beans", 3),
            Item("bottle of rum", 2),
            Item("a swash", 4)
        )
    }

    @Test
    fun `lists can be grouped to create a map of lists of items`(){
        val shoppingList = listOf(
            Item("can of baked beans", 3),
            Item("can of peaches", 2),
            Item("bottle of rum", 2),
            Item("bottle of oil", 4),
            Item("a buckle", 2),
            Item("a swash", 4)
        )

        val groupByCountMap = shoppingList.groupBy { it.count }

        assertThat(groupByCountMap.keys).hasSize(3)
        assertThat(groupByCountMap.keys).containsExactlyInAnyOrder(2, 3, 4)

        assertThat(groupByCountMap[2]).containsExactlyInAnyOrder(
            Item("can of peaches", 2),
            Item("bottle of rum", 2),
            Item("a buckle", 2)
        )

        assertThat(groupByCountMap[3]).containsExactlyInAnyOrder(
            Item("can of baked beans", 3)
        )

        assertThat(groupByCountMap[4]).containsExactlyInAnyOrder(
            Item("bottle of oil", 4),
            Item("a swash", 4)
        )
    }

    @Test
    fun `grouping could be more complicated`(){
        val shoppingList = listOf(
            Item("can of baked beans", 3),
            Item("a swash", 4),
            Item("can of peaches", 2),
            Item("bottle of oil", 4),
            Item("a buckle", 2),
            Item("bottle of rum", 2)

        )

        val groupByCategoryMap = shoppingList.groupBy {
            when{
                it.text.contains("can") -> "cans"
                it.text.contains("bottle") -> "bottles"
                else -> "misc"
            }
        }

        assertThat(groupByCategoryMap.keys).hasSize(3)
        assertThat(groupByCategoryMap.keys).containsExactlyInAnyOrder("cans", "bottles", "misc")

        assertThat(groupByCategoryMap["cans"]).containsExactlyInAnyOrder(
            Item("can of baked beans", 3),
            Item("can of peaches", 2)
        )

        assertThat(groupByCategoryMap["bottles"]).containsExactlyInAnyOrder(
            Item("bottle of rum", 2),
            Item("bottle of oil", 4)
        )

        assertThat(groupByCategoryMap["misc"]).containsExactlyInAnyOrder(
            Item("a buckle", 2),
            Item("a swash", 4)
        )
    }

}