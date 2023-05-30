package com.example.login

class LoginRepository {
    fun login(user: String, password: String): Boolean {
        return (user.isNotEmpty() && password.isNotEmpty())
    }
}