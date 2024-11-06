package com.example.uilover.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.uilover.R
import com.example.uilover.databinding.FragmentLoginSignUpScreenBinding
import com.example.uilover.model.DataBaseHelper
import com.example.uilover.model.repository.LoginSignUpRepository
import com.example.uilover.utils.CommonUtils.checkEmailFormat
import com.example.uilover.viewmodel.LoginSignUpScreenViewModel
import com.example.uilover.viewmodel.LoginSignUpViewModelFactory

class LoginSignUpScreen :Fragment() {

    companion object {
        fun newInstance() = LoginSignUpScreen()
        const val SIGNUP = "Signup"
    }

    private lateinit var viewModel: LoginSignUpScreenViewModel
    private lateinit var binding: FragmentLoginSignUpScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginSignUpScreenBinding.inflate(inflater,container,false)

        val databaseHelper = DataBaseHelper(requireContext())
        val userRepository = LoginSignUpRepository(databaseHelper)

        val viewModelFactory = LoginSignUpViewModelFactory(userRepository)
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[LoginSignUpScreenViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.isNewUSer = false
        onClickActions()
    }

    private fun onClickActions(){
        binding.loginButton.setOnClickListener {
            val email = binding.emailTv.text.toString()
            val password = binding.passwordTv.text.toString()
            val confirmPassword = binding.confirmPasswordTv.text.toString()

            if(email.isEmpty() || password.isEmpty() || (confirmPassword.isEmpty() && binding.confirmPasswordTv.isVisible)){
                setErrorMessage(resources.getString(R.string.fields_can_not_be_left_unfilled))
                return@setOnClickListener
            }

            if (checkEmailFormat(email)){
                if(binding.signUpTv.text == SIGNUP){ // Login an existing user
                    if (viewModel.checkUserLogin( email, password)) {
                        findNavController().navigate(R.id.action_loginSignUpScreen_to_homeScreen)
                    }else {
                        setErrorMessage(resources.getString(R.string.wrong_email_or_password))
                    }
                }else{
                    if(password.length <6 || password.length >13){
                        setErrorMessage(resources.getString(R.string.password_should_contain))
                        return@setOnClickListener
                    }
                    if(password != confirmPassword){
                        setErrorMessage(resources.getString(R.string.password_and_confirm))
                    }else{
                        // registering new user
                        if (viewModel.registerNewUser( email, password)) {
                            findNavController().navigate(R.id.action_loginSignUpScreen_to_homeScreen)
                        }else{
                            setErrorMessage(resources.getString(R.string.sorry_couldnt_signup))
                        }
                    }
                }
            }else{
                setErrorMessage(resources.getString(R.string.enter_your_email))
            }
        }

        binding.signUpTv.setOnClickListener {
            binding.errorTv.isVisible = false
            clearFields()
            binding.isNewUSer = binding.signUpTv.text == SIGNUP
        }
    }

    private fun setErrorMessage(message:String){
        binding.errorTv.isVisible = true
        binding.errorTv.text = message
    }

    private fun clearFields(){
        binding.passwordTv.text.clear()
        binding.confirmPasswordTv.text.clear()
        binding.emailTv.text.clear()
    }


}