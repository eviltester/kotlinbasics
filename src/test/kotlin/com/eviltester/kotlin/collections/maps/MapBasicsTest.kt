package com.eviltester.kotlin.collections.maps

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class MapBasicsTest {

    data class Item(val text: String, val count: Int)

    /*
        A Map should not be confused with the process of mapping `.map`

        A Map is a set of keys which 'map' to another object e.g.

        Map<String,List<Item>> -> a set of keys which are Strings which map to a List of Items

        the process of `.map` on a List returns a List
     */

    @Test
    fun `a map can be empty`(){

        val mapOfItems = emptyMap<String,Int>()

        assertThat(mapOfItems).hasSize(0)
        assertThat(mapOfItems).isEmpty()

    }

    @Test
    fun `a mutable map can be added to by putting object into key position`(){

        val mapOfItems = mutableMapOf<String, Int>()

        mapOfItems.put("can of beans", 1)

        assertThat(mapOfItems.keys).hasSize(1)
    }


    @Test
    fun `items in a map can be accessed via the key as index`(){

        val mapOfItems = mapOf("can of beans" to 1)

        assertThat(mapOfItems["can of beans"]).isEqualTo(1)
    }

    @Test
    fun `a map key can only be used once as index`(){

        // keys are a set, we can't add multiple items with the same key
        val mapOfItems = mutableMapOf("can of beans" to 1)

        mapOfItems.put("can of beans",4)

        assertThat(mapOfItems["can of beans"]).isEqualTo(4)
    }

    @Test
    fun `multiple items can be put into the map at the same time`(){

        // keys are a set, we can't add multiple items with the same key
        val mapOfItems = mutableMapOf("can of beans" to 1)

        mapOfItems.putAll(mapOf("can of peaches" to 4, "bottle of rum" to 2))

        assertThat(mapOfItems["can of beans"]).isEqualTo(1)
        assertThat(mapOfItems["can of peaches"]).isEqualTo(4)
        assertThat(mapOfItems["bottle of rum"]).isEqualTo(2)
    }

    @Test
    fun `items can be removed from a map`(){

        // keys are a set, we can't add multiple items with the same key
        val mapOfItems = mutableMapOf("can of beans" to 1)

        mapOfItems.remove("can of beans")

        assertThat(mapOfItems.containsKey("can of beans")).isFalse()
        assertThat(mapOfItems["can of beans"]).isEqualTo(null)
    }

    @Test
    fun `items can be removed from a map with -=`(){

        // keys are a set, we can't add multiple items with the same key
        val mapOfItems = mutableMapOf("can of beans" to 1)

        mapOfItems -= "can of beans"

        assertThat(mapOfItems.containsKey("can of beans")).isFalse()
        assertThat(mapOfItems["can of beans"]).isEqualTo(null)
    }

    @Test
    fun `plus += operator can join maps`(){

        // keys are a set, we can't add multiple items with the same key
        val mapOfItems = mutableMapOf("can of beans" to 1)

        mapOfItems += mapOf("can of peaches" to 4, "bottle of rum" to 2)
        mapOfItems +=  Pair("bottle of oil", 3)

        assertThat(mapOfItems).hasSize(4)

        assertThat(mapOfItems["can of beans"]).isEqualTo(1)
        assertThat(mapOfItems["can of peaches"]).isEqualTo(4)
        assertThat(mapOfItems["bottle of rum"]).isEqualTo(2)
        assertThat(mapOfItems["bottle of oil"]).isEqualTo(3)
    }

    @Test
    fun `plus operator can join maps into a new map`(){

        // keys are a set, we can't add multiple items with the same key
        val mapOfItems = mutableMapOf("can of beans" to 1)

        val newMap = mapOfItems + mapOf("can of peaches" to 4, "bottle of rum" to 2)

        assertThat(mapOfItems).hasSize(1)
        assertThat(newMap).hasSize(3)

        assertThat(newMap["can of beans"]).isEqualTo(1)
        assertThat(newMap["can of peaches"]).isEqualTo(4)
        assertThat(newMap["bottle of rum"]).isEqualTo(2)
    }

    @Test
    fun `plus operator can join maps and pairs into a new map`(){

        // keys are a set, we can't add multiple items with the same key
        val mapOfItems = mutableMapOf("can of beans" to 1)

        val newMap = mapOfItems + Pair("bottle of oil", 3) + setOf(
            "can of peaches" to 4,
            "bottle of rum" to 2
        )

        assertThat(mapOfItems).hasSize(1)
        assertThat(newMap).hasSize(4)

        assertThat(newMap["bottle of oil"]).isEqualTo(3)
        assertThat(newMap["can of beans"]).isEqualTo(1)
        assertThat(newMap["can of peaches"]).isEqualTo(4)
        assertThat(newMap["bottle of rum"]).isEqualTo(2)
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
    fun `list grouping could be more complicated to create more semantic map`(){
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