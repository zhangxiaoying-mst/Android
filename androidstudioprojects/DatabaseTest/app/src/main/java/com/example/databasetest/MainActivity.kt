package com.example.databasetest

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper=MyDatabaseHelper(this,"BookStore.db",2)
        val createDatabase:Button=findViewById(R.id.createDatabase)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }

        val addData:Button=findViewById(R.id.addData)
        addData.setOnClickListener {
            val db=dbHelper.writableDatabase
            val values1=ContentValues().apply {
                put("name","The Da Vinci Code")
                put("author","Dan Brown")
                put("pages",454)
                put("price",16.69)
            }
            db.insert("Book",null,values1)

            val values2=ContentValues().apply {
                put("name","The Lost Symbol")
                put("author","Dan Brown")
                put("pages",510)
                put("price",16.96)
            }
            db.insert("Book",null,values2)
        }

        val updateData:Button=findViewById(R.id.updateData)
        updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("Book", values, "name =?", arrayOf("The Da Vinci Code"))
        }

        val deleteData:Button=findViewById(R.id.deleteData)
        deleteData.setOnClickListener {
            val db=dbHelper.writableDatabase
            db.delete("Book","pages>?", arrayOf("500"))
        }

        val queryData:Button=findViewById(R.id.queryData)
        queryData.setOnClickListener {
            val db=dbHelper.writableDatabase
            val cursor=db.query("Book",null,null,null,null,null,null)
            if(cursor.moveToFirst())
            {
                do{
                    val name=cursor.getString(cursor.getColumnIndex("name"))
                    val author=cursor.getString(cursor.getColumnIndex("author"))
                    val pages=cursor.getInt(cursor.getColumnIndex("pages"))
                    val price=cursor.getDouble(cursor.getColumnIndex("price"))

                    Log.d("MainActivity","book name is $name")
                    Log.d("MainActivity","book author is $author")
                    Log.d("MainActivity","book pages is $pages")
                    Log.d("MainActivity","book price is $price")

                }while (cursor.moveToNext())
            }
            cursor.close()
        }

        val replaceData:Button=findViewById(R.id.replaceData)
        replaceData.setOnClickListener {
            val db=dbHelper.writableDatabase
            db.beginTransaction()
            try
            {
                db.delete("Book",null,null)
                if(true)
                {
                    throw NullPointerException()
                }
                val values=ContentValues().apply {
                    put("name","Game of Thrones")
                    put("author","George Matin")
                    put("page",720)
                    put("price",20.85)
                }
                db.insert("Book",null,values)
                db.setTransactionSuccessful()
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                db.endTransaction()
            }
        }
    }

}