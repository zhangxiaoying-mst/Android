package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button=findViewById(R.id.button)
        button.setOnClickListener {
            val progressBar:ProgressBar=findViewById(R.id.progressBar)
            progressBar.progress=progressBar.progress+10

            val imageView:ImageView=findViewById(R.id.imageView)
            imageView.setImageResource(R.drawable.img1)

            AlertDialog.Builder(this).apply {
                setTitle("This is Diaglog")
                setMessage("Something important.")
                setCancelable(false)
                setPositiveButton("OK"){
                    dialog,which->
                }
                setNegativeButton("Cancel"){
                    dialog,which->
                }
                show()
            }
        }
    }
}