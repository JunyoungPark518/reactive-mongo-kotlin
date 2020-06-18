package kr.jypark.jpa.util

class StreamTemplate{

    fun Int.square(): Int = this * this
    fun <T> List<T>.evens(): List<T> = withIndex().filter { it.index % 2 == 0 }.map { it.value }
    fun List<Int>.squareEvens(): List<Int> = evens().map { it.square() }

    fun test123() {
        val a = (0..10)
                .filter { it % 2 == 0 }
                .map { it * it }
                .fold("") { s, i ->
                    (if (s != "") s + "_" else "") + i.toString()
                }

        print(a)
    }
}