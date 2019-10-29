package com.zc.test.mybindertestapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         IMediaService(object :onInformationArriveListener{
            override fun onArrive(code: Int, info: String) {
                Log.e(TAG,"$code - $info")
            }
        })
         */
    }

    fun start_info_act(view: View){

        Log.e(TAG,"start_info_act");
        val intent = Intent(this,InfoActivity::class.java)
        startActivity(intent)

    }
}
