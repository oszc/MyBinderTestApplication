package com.zc.test.mybindertestapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    val TAG = "InfoActivity"
    var mServiceBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        if (!mServiceBound) {
            mServiceBound = true
            val intent = Intent(this, MyService::class.java)
            bindService(intent, object : ServiceConnection {
                override fun onServiceDisconnected(p0: ComponentName?) {
                    Log.e(TAG,"onServiceDisconnected");
                }
                override fun onServiceConnected(p0: ComponentName?, p1: IBinder) {

                    val asInterface = IMyAidlInterface.Stub.asInterface(p1)
                    asInterface.name="Hello~Justin~Zhang~"
                    Log.e(TAG,"onServiceConnected~ ${asInterface.name}");
                }
            }, Context.BIND_AUTO_CREATE)
        }
    }
}
