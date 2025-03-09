package com.eviltester.leetexercises.algorithms.totalval.stringmutate

class StringMutatorWithFold {

    enum class Parsing {
        FINDING_START_OF_SUBSTRING, PROCESSING_SUBSTRING, FINISHED_PROCESSING_SUBSTRING
    }

    // folding was much slower with long strings
    /*
        fold will aggregate the results on completion
     */
    fun maximumNumber(num: String, change: IntArray): String {

        var state = Parsing.FINDING_START_OF_SUBSTRING

        return num.fold("") { returnString, char ->
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

            returnString + if (state == Parsing.PROCESSING_SUBSTRING) {
                changeCharValue.toString()
            } else {
                char
            }
        }
    }
}