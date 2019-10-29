package com.zc.test.mybindertestapplication

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    val TAG = "MyService"
    var aName: String = "defaultName"

    /*
    val mBinder =object :IMyAidlInterface.Stub(){
        override fun getName(): String {
            Log.e(TAG,"getName")
            return aName
        }

        override fun setName(name: String?) {
            Log.e(TAG,"setName $name");
            aName = name?:"defaultName"
        }
    }
     */
    val mBinder =  IMediaServiceBinder(object : onInformationArriveListener {
        override fun onArrive(code: Int, info: String) {
            Log.e(TAG, "onArrive $code $info")
        }


    })

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    override fun bindService(service: Intent?, conn: ServiceConnection, flags: Int): Boolean {
        return super.bindService(service, conn, flags)
    }


}
