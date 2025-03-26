package com.example.pinkauth.features.signup.presentation.di

import com.example.pinkauth.commom.validator.FormValidator
import com.example.pinkauth.features.signup.presentation.state.SignUpState
import com.example.pinkauth.features.signup.presentation.validator.SignUpFormValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface SignUpFormValidatorModule {

    @Binds
    fun bindSignUpFormValidator(signUpFormValidator: SignUpFormValidator): FormValidator<SignUpState>
}