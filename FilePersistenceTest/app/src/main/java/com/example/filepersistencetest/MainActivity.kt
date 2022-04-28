package com.example.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputText=load()
        val editText:EditText=findViewById(R.id.editText)
        if(inputText.isNotEmpty())
        {
            editText.setText(inputText)
            editText.setSelection(inputText.length)
            Toast.makeText(this,"Restoring succeeded",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val editText:TextView=findViewById(R.id.editText)
        val inputText=editText.text.toString()
        save(inputText)
    }

    private fun save(inputText:String)
    {
        try {
            val output=openFileOutput("data",Context.MODE_PRIVATE)
            val write=BufferedWriter(OutputStreamWriter(output))
            write.use {
                it.write(inputText)
            }
        }catch (e:IOException){
            e.printStackTrace()
        }
    }

    fun load():String{
        val content=StringBuilder()
        try {
            val input=openFileInput("data")
            val reader=BufferedReader(InputStreamReader(input))
            reader.use{
                reader.forEachLine {
                    content.append(it)
                }
            }
        }catch (e:IOException){
            e.printStackTrace()
        }
        return content.toString()
    }
}