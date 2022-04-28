package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

@Suppress("DEPRECATION")
class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity","Task id is $taskId")
        setContentView(R.layout.first_layout)

        val button1:Button=findViewById(R.id.button1)

        button1.setOnClickListener{

            val intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)

           // Toast.makeText(this,"You clicked Button1",Toast.LENGTH_SHORT).show()
            //finish()
            // val intent=Intent("com.example.activitytest.ACTION_START")
            // intent.addCategory("com.example.activitytest.MY_CATEGORY")
            // startActivity(intent)
            //
            //
            // val intent=Intent(Intent.ACTION_DIAL)
            // intent.data= Uri.parse("tel:10086")
            // startActivity(intent)
//            val data="Hello SecondActivity"
//            val intent=Intent(this,SecondActivity::class.java)
//            startActivityForResult(intent,1)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity","onRestart")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.add -> Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show()
            R.id.remove->Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode)
        {
            1->if(resultCode== RESULT_OK)
            {
                val returnedData=data?.getStringExtra("data_return")
                Log.d("FirstActivity","returned data is $returnedData")
            }
        }
    }
}