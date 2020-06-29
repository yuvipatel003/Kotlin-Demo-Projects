package com.yuvrajpatel.sqlite_kotlin

class User {

    var id = 0
    var name = ""
    var age = 0

    constructor(name : String, age : Int){
        this.name = name
        this.age = age
    }
}