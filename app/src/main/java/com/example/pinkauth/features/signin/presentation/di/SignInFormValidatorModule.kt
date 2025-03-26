package com.example.pinkauth.features.signin.presentation.di

import com.example.pinkauth.commom.validator.FormValidator
import com.example.pinkauth.features.signin.presentation.state.SignInState
import com.example.pinkauth.features.signin.presentation.validator.SignInFormValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface SignInFormValidatorModule {

    @Binds
    fun bindSignInFormValidator(signInFormValidator: SignInFormValidator): FormValidator<SignInState>
}