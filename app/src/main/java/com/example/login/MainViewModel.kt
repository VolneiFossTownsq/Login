package com.example.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val loginRepository = LoginRepository()

    private val _isSucess = MutableLiveData<Boolean>()
    val isSucess = _isSucess


    fun enableAcess(): LiveData<Boolean> {
        return isSucess
    }

    fun login(user: String, password: String) {
        _isSucess.value = loginRepository.login(user, password)
    }

}