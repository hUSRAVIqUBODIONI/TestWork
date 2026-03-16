package com.example.testwork.presentation.Auth

import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(val auth : FirebaseAuth): ViewModel(){
    init {
        Log.d("Test","InitViewModel")
    }

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage

    private val context = LocalContext

    fun registerUser(email: String, password: String,onSuccess : (Boolean) -> Unit){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess(true)
            } else {
                viewModelScope.launch {
                    _toastMessage.emit(task.exception?.message ?: "Registration failed")
                }
            }
        }
    }

    fun logIn(email: String, password: String,onSuccess : (Boolean) -> Unit){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if (task.isSuccessful){
                onSuccess(true)
            }else{
                viewModelScope.launch {
                    _toastMessage.emit(task.exception?.message ?: "Login failed")
                }
            }
        }
    }
}