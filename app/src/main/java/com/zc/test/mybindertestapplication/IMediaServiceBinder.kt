package com.zc.test.mybindertestapplication

import android.os.Binder
import android.os.Parcel

/**
 * 2019/10/28  4:41 下午
 * Created by zhangchen.
 */
class IMediaServiceBinder(val listener: onInformationArriveListener): Binder(){
    override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
        data.enforceInterface(IMediaServiceBinder::class.java.name)
        val info = data.readString()!!
        listener.onArrive(code,info)
        reply?.writeNoException()
        reply?.writeString("All right!")
        return true
    }
}

interface onInformationArriveListener{
    fun onArrive(code:Int,info:String);
}