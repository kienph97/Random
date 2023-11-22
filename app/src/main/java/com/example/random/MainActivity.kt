package com.example.random

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.example.random.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    var mService: IMyAidlInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val intentService = Intent(this, AidlService::class.java)
        bindService(intentService, mCollection, Context.BIND_AUTO_CREATE)
        startService(intentService)
//        mBinding.btn.setOnClickListener {
//            val a = mService?.receiveData()
//            Log.d("kien", "$a")
//        }
    }

    val mCollection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            mService = IMyAidlInterface.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {

        }

    }
}