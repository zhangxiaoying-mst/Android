package com.example.contactstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private val contactsList=ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,contactsList)

        val contactsView:ListView=findViewById(R.id.contactsView)
        contactsView.adapter=adapter

        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission))
    }
}