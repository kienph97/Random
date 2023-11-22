package com.example.random

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi

class AidlService: Service() {
    private val NOTIFICATION_ID = 1
    private var mNotification: Notification? = null
    override fun onBind(p0: Intent?): IBinder? {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        //startForegroundService()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    val mBinder = object : IMyAidlInterface.Stub() {
        override fun basicTypes(
                anInt: Int,
                aLong: Long,
                aBoolean: Boolean,
                aFloat: Float,
                aDouble: Double,
                aString: String?
        ) {
            TODO("Not yet implemented")
        }

        override fun receiveData(): Int {
            Log.d("kien", "1")
            return 1
        }

        override fun setValueData(a: Int) {
            Log.d("kien", "$a")
        }

    }

//    private fun startForegroundService() {
//        startForeground(NOTIFICATION_ID, getNotification())
//    }
//
//    private fun getNotification(): Notification? {
//        if (mNotification == null) {
//            var title = "IPC Testing"
////            try {
////                title = mPlayerManager.getSongName()
////            } catch (e: RemoteException) {
////                e.printStackTrace()
////            }
//            mNotification = Notification.Builder(this).setContentTitle(title)
//                    .setContentText("IPC Testing")
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .build()
//        }
//        return mNotification
//    }
}