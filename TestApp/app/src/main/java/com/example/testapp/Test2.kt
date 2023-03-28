package com.example.testapp

fun main(args: Array<String>) {
        var letter = readLine()!![0]
        val names = arrayOf("John", "David", "Amy", "James", "Amanda", "Dave", "Bob", "Billy", "Bobby", "Diana", "Lenny", "Gina")

        var filteredNames = names.filter{ it[0] == letter }

        for(n in filteredNames)
            println(n)
}
