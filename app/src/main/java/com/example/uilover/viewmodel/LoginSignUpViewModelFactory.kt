package com.example.uilover.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uilover.model.repository.LoginSignUpRepository


class LoginSignUpViewModelFactory(private val userRepository: LoginSignUpRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginSignUpScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginSignUpScreenViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}