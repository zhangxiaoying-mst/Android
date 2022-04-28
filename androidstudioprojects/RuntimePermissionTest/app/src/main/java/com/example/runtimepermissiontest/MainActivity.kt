package com.example.runtimepermissiontest

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val makeCall:Button=findViewById(R.id.makeCall)

        makeCall.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.CALL_PHONE)!=
                PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(this,
                        arrayOf(android.Manifest.permission.CALL_PHONE),1)
            else{
                call()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode)
        {
            1->{
                if(grantResults.isNotEmpty()&&grantResults[0]==
                        PackageManager.PERMISSION_GRANTED){
                    call()
                }else{
                    Toast.makeText(this,"you denied the permission",
                    Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun call(){
        try {
            val intent=Intent(Intent.ACTION_CALL)
            intent.data=Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e:SecurityException){
            e.printStackTrace()
        }
    }
}