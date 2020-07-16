package com.yuvrajpatel.mvp_demo_kotlin

open class MainActivityPresenter {
    lateinit var user : User
    lateinit var view : View


    constructor(view : View){
        this.user = User("","")
        this.view = view
    }

    fun updateFullName(fullname : String){
        user.setfullName(fullname)
        view.updateUserInfoTextView(user.toString())
    }

    fun updateEmail(email : String){
        user.setemail(email)
        view.updateUserInfoTextView(user.toString())
    }

    public interface View {

        fun updateUserInfoTextView(info : String)
//        fun showProgressbar()
//        fun hideProgressbar()
    }
}