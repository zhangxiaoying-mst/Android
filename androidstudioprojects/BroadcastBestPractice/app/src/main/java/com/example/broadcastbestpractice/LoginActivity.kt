package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*

class LoginActivity:BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs=getPreferences(Context.MODE_PRIVATE)
        val accountEdit:TextView=findViewById(R.id.accountEdit)
        val passwordEdit:TextView=findViewById(R.id.passwordEdit)
        val remeberPass:CheckBox=findViewById(R.id.rememberPass)
        val login:Button=findViewById(R.id.login)

        val isRemeber=prefs.getBoolean("remember_password",false)

        if(isRemeber)
        {
            val account=prefs.getString("account","")
            val password=prefs.getString("password","")


            accountEdit.setText(account)
            passwordEdit.setText(password)

            remeberPass.isChecked=true
        }

        login.setOnClickListener {
            val account=accountEdit.text.toString()
            val password=passwordEdit.text.toString()

            if(account=="admin"&&password=="123456")
            {
                val editor=prefs.edit()
                if(remeberPass.isChecked){
                    editor.putBoolean("remember_password",true)
                    editor.putString("account",account)
                    editor.putString("password",password)
                }
                else{
                    editor.clear()
                }
                editor.apply()

                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"account or password is invalid",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }
}