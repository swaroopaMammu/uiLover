package com.example.uilover.viewmodel

import androidx.lifecycle.ViewModel
import com.example.uilover.model.repository.LoginSignUpRepository


class LoginSignUpScreenViewModel(private val repository: LoginSignUpRepository) : ViewModel()  {


    fun registerNewUser(email:String,password:String):Boolean{
        return repository.registerNewUser( email, password)
    }

    fun checkUserLogin(email:String,password:String):Boolean{
        return repository.checkUserLogin( email, password)
    }
}