package com.example.uilover.utils

object CommonUtils {

     fun checkEmailFormat(email: String): Boolean {
         val emailRegex = Regex(
             "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
         )
         return emailRegex.matches(email)
    }
}