package com.zc.test.mybindertestapplication

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return Binder()
    }

    override fun bindService(service: Intent?, conn: ServiceConnection, flags: Int): Boolean {

        return super.bindService(service, conn, flags)
    }


}
