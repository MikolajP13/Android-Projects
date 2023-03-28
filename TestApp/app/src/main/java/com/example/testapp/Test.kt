package com.example.testapp

open class Test {
    // val - stała
    val val1: String = "abcd"
    val val2: Int = 99
    val val3: Boolean = true

    // var - zmienna
    lateinit var var1: String
    var var2: String = "abcd2"
    var var3: Int = 100
}

class Wrapper(val test: Test) {
    fun printVal1(){
        println(test.val1)
    }

    fun initVar1(){
        test.var1 = "initVar1"
    }
}

//stosując ? jeśli coś jest nullem to dalsze rzeczy się nie wywołają