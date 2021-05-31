package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.isNotEmpty()) {
            var beforeArray = sadArray.toMutableList()
            var afterArray = mutableListOf<Int>()
            var isSadArray = true

            while (isSadArray) {
                val arraySize = beforeArray.size
                afterArray = mutableListOf(beforeArray[0])
                for (i in 1..arraySize - 2) {
                    if ((beforeArray[i - 1] + beforeArray[i + 1]) >= beforeArray[i]) {
                        afterArray.add(beforeArray[i])
                    }
                }
                afterArray.add(beforeArray[arraySize - 1])
                if (beforeArray.size == afterArray.size) {
                    isSadArray = false
                } else {
                    beforeArray = afterArray
                }
            }

            return afterArray.toIntArray()
        } else {
            return sadArray
        }
    }
}
