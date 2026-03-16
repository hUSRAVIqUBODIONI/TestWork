package com.example.testwork.screens.Auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(val auth : FirebaseAuth): ViewModel(){
    init {
        Log.d("Test","InitViewModel")
    }
}