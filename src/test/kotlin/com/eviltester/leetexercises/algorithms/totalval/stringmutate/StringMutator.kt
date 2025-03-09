package com.eviltester.leetexercises.algorithms.totalval.stringmutate

class StringMutator {

    enum class Parsing {
        FINDING_START_OF_SUBSTRING, PROCESSING_SUBSTRING, FINISHED_PROCESSING_SUBSTRING
    }

    fun maximumNumber(num: String, change: IntArray): String {

        var state = Parsing.FINDING_START_OF_SUBSTRING

        // originally processed as string
//                return num.split("").filter { it != ""  }.map { char ->
//                    val charAsIndex = char.toInt()

        // slightly optimised to process as chars
        return num.map { char ->
            val charAsIndex = char - '0'

            val changeCharValue = change[charAsIndex]

            // check for state change
            state = when (state) {
                Parsing.FINDING_START_OF_SUBSTRING -> if (changeCharValue > charAsIndex) {
                    Parsing.PROCESSING_SUBSTRING
                } else {
                    state
                }

                Parsing.PROCESSING_SUBSTRING -> if (changeCharValue < charAsIndex) {
                    Parsing.FINISHED_PROCESSING_SUBSTRING
                } else {
                    state
                }

                else -> state
            }

            if (state == Parsing.PROCESSING_SUBSTRING) {
                changeCharValue.toString()
            } else {
                char
            }

        }.joinToString(separator = "")
    }
}