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
    companion object{
        var n:Int = 100
    }
    val TAG = "InfoActivity"
    var mServiceBound = false
    val sc = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.e(TAG, "onServiceDisconnected");
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder) {
            val data = Parcel.obtain()
            val replay = Parcel.obtain()
            data.writeInterfaceToken(IMediaServiceBinder::class.java.name)
            data.writeString("HelloWorld")
            val result = p1.transact(n++, data, replay, 0)
            replay.readException()
            val replayString = replay.readString()
            Log.e(TAG, "onServiceConnected result:$result replay String: $replayString - $replay");

            replay.recycle()
            data.recycle()
            /*
            val asInterface = IMyAidlInterface.Stub.asInterface(p1)
            asInterface.name="Hello~Justin~Zhang~"
            Log.e(TAG,"onServiceConnected~ ${asInterface.name}");
             */
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        if (!mServiceBound) {
            mServiceBound = true
            val intent = Intent(this, MyService::class.java)
            bindService(intent, sc, Context.BIND_AUTO_CREATE)
        }
    }

    override fun finish() {
        unbindService(sc)
        super.finish()
    }

}
