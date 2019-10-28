package com.zc.test.mybindertestapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.Parcel
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    val TAG = "InfoActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val intent = Intent(this,MyService::class.java)
        bindService(intent,object:ServiceConnection{
            override fun onServiceDisconnected(p0: ComponentName?) {
            }

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder) {
                val data= Parcel.obtain();
                val reply= Parcel.obtain();
                data.writeString("HelloJava")
                p1.transact(100,data,reply,0)
                val result = reply.readString()
                Log.e(TAG,"onServiceConnected result:$result");
            }
        },Context.BIND_AUTO_CREATE)

        Log.e(TAG,  "name:$name")
    }
}
