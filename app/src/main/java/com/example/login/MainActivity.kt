package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var userNick: EditText? = null
    private var userPassword: EditText? = null
    private var confirmLogin: Button? = null
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        userNick = findViewById(R.id.loginNickName)
        userPassword = findViewById(R.id.loginPassword)
        confirmLogin = findViewById(R.id.buttonLogin)


        setupBinding()
        onClick()

    }

    private fun setupBinding() {
        viewModel?.enableAcess()?.observe(this){ isSucess ->
            if (isSucess){
                Toast.makeText(this, "Login confirmado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Falha no login", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onClick(){
        confirmLogin?.setOnClickListener {
            val user = userNick?.text.toString()
            val password = userPassword?.text.toString()

            viewModel?.login(user, password)
        }
    }

}