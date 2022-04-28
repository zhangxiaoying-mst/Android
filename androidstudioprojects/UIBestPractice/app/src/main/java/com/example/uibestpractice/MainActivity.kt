package com.example.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),View.OnClickListener{

    private val msgList=ArrayList<Msg>()
    private var adapter:MsgAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMsg()
        val layoutManager=LinearLayoutManager(this)
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=layoutManager
        adapter= MsgAdapter(msgList)
        recyclerView.adapter=adapter

        val send:Button=findViewById(R.id.send)
        send.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        val send:Button=findViewById(R.id.send)
        when(v){
            send->{
                val inputText:EditText=findViewById(R.id.inputText)
                val content=inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg=Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size-1)

                    val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
                    recyclerView.scrollToPosition(msgList.size-1)

                    inputText.setText("")
                }
            }

        }
    }

    private fun initMsg(){
        val msg1=Msg("Hello guy.",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2=Msg("Hello,Who is that?",Msg.TYPE_SENT)
        msgList.add(msg2)

    }
}