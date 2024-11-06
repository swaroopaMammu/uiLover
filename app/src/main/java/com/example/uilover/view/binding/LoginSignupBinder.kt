package com.example.uilover.view.binding

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun setVisibility(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("loginButtonText")
fun setLoginButtonText(textView: TextView, isNewUser:Boolean) {
    textView.text = if(isNewUser) "Signup" else "Login"
}

@BindingAdapter("loginSignUpSwitch")
fun setLoginSignUpSwitch(textView: TextView, isNewUser:Boolean) {
    textView.text = if(isNewUser) "Login" else "Signup"
}

@BindingAdapter("hasAccount")
fun setHasAccountOrNot(textView: TextView, isNewUser:Boolean) {
    textView.text = if(isNewUser) "Already have an account?" else "Don\'t have an account?"
}

@BindingAdapter("loginWith")
fun setLoginOrSignupWith(textView: TextView, isNewUser:Boolean) {
    textView.text = if(isNewUser) "Signup with" else "Or Login with"
}