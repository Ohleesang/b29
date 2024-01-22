


class Solution {

    private fun checkExpression(x: Int, operator: String, y: Int, z: Int): String {
        var res = 0
        when (operator) {
            "+" -> res = x + y
            "-" -> res = x - y
        }

        return if (res == z) "O"
        else "X"
    }

    fun solution(quiz: Array<String>): Array<String> {
        val answer = mutableListOf<String>()
        val regex = Regex("""(-?\d+)\s([+-])\s(-?\d+)\s=\s(-?\d+)""")
        var x = 0
        var y = 0
        var z = 0
        var operator = ""

        quiz.forEach {
            val matchResult = regex.find(it)
            matchResult?.run {
                x = groupValues[1].toInt()
                operator = groupValues[2]
                y = groupValues[3].toInt()

                z = groupValues[4].toInt()

                answer.add(checkExpression(x, operator, y, z))
            }
        }
        return answer.toTypedArray()
    }
}

fun main() {
    Solution().solution(
        arrayOf(
            "3 - -4 = -3",
        )//X,O
    )
    Solution().solution(
        arrayOf(
            "19 - 6 = 13",
            "5 + 66 = 71",
            "5 - 15 = 63",
            "3 - 1 = 2"
        )//O,O,X,O
    )
}