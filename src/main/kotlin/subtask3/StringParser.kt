package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val brackets = mapOf('<' to '>', '(' to ')', '[' to ']')
        val output = ArrayList<String>()

        inputString.forEachIndexed { index, char ->
            if (char in brackets.keys) {
                var counter = 0
                val finalBracket = brackets[char]

                for(i in index..inputString.length) {
                    if (inputString[i] == char) {
                        counter++
                    }
                    if (inputString[i] == finalBracket) {
                        counter--
                        if (counter == 0) {
                            output.add(inputString.substring(index+1 until i))
                            break
                        }
                    }
                }
            }
        }
        return output.toTypedArray()
    }
}
