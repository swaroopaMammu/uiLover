package com.example.uilover.model.repository

import com.example.uilover.model.DataBaseHelper

class LoginSignUpRepository(private val dbHelper: DataBaseHelper) {


    fun registerNewUser(email:String,password:String):Boolean{
        return dbHelper.registerUser( email, password)
    }

    fun checkUserLogin(email:String,password:String):Boolean{
        return dbHelper.checkUser( email, password)
    }

}