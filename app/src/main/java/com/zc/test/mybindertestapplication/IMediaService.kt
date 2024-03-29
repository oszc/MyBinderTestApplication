package com.zc.test.mybindertestapplication

import android.os.Binder
import android.os.Parcel

/**
 * 2019/10/28  4:41 下午
 * Created by zhangchen.
 */
class IMediaService(val listener: onInformationArriveListener): Binder(){

    override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
        val info = data.readString()!!
        listener.onArrive(code,info)
        reply?.writeString("All right!")
        return super.onTransact(code, data, reply, flags)
    }
}

interface onInformationArriveListener{
    fun onArrive(code:Int,info:String);
}