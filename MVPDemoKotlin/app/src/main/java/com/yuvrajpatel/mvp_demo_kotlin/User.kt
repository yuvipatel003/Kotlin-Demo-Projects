package com.yuvrajpatel.mvp_demo_kotlin

class User {

    lateinit var fullName : String
    lateinit var email : String

    constructor(){

    }

    constructor(fullName : String, email : String){
        this.fullName = fullName
        this.email = email
    }

    fun getfullName() : String {
        return fullName
    }

    fun setfullName(fullName : String) {
        this.fullName = fullName
    }

    fun getemail() : String {
        return email
    }

    fun setemail(email : String) {
        this.email = email
    }

    override fun toString(): String {
        return "Email: " + email + "\nName: " + fullName
    }
}