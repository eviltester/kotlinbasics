package com.eviltester.leetexercises.algorithms.strings.substringconcatenation

class SubstringConcatenationChecker {

    fun findSubstring(s: String, words: Array<String>): List<Int>{

        var sIndex = 0
        val wordLength = words[0].length
        val numberOfWordsInSubstring = words.size
        val subStringMaxLength = numberOfWordsInSubstring * wordLength
        val subStringIndexes = mutableListOf<Int>()

        // no guarantee that string is only made up of words so work char by char
        while(sIndex <= s.length - subStringMaxLength){

            val possibleSubstring = s.substring(startIndex = sIndex, endIndex = sIndex + subStringMaxLength)
            val possibleSubStringWords = possibleSubstring.splitByWordLength(wordLength)

            // now check that every item in words is in possibleSubStringWords
            if(possibleSubStringWords.containsAllIndividually(words.toList())){
                subStringIndexes.add(sIndex)
            }

            sIndex++
        }

        return subStringIndexes
    }
}

fun List<String>.containsAllIndividually(strings: List<String>): Boolean {
    // conntainsAll ignores the duplicated aspect of words and matches too often
    // need to check all words and the counts of each word
    val subStringWords = this.groupBy { it }
    val wordsHash = strings.groupBy { it }
    return subStringWords.keys.all {
        wordsHash.containsKey(it) && wordsHash.get(it)!!.size == subStringWords.get(it)!!.size
    }
}

fun String.splitByWordLength(wordLength: Int): List<String> {
    // split string into list of words by word length
    val splitWords = mutableListOf<String>()

    var startSplitIndex=0
    while(startSplitIndex<this.length){
        try {
            splitWords.add(this.substring(startSplitIndex, startSplitIndex + wordLength))
        }catch( e:StringIndexOutOfBoundsException){
            splitWords.add(this.substring(startSplitIndex))
        }
        startSplitIndex+=wordLength
    }

    return splitWords
}

