package com.example.vaccinationandcovidhcarecentrenotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class SuccessBooking : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_booking)
        val resultIntent = Intent(this@SuccessBooking, MsgNotiScreen::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this@SuccessBooking,
            0,
            resultIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )
        val notificationID = 101
        val channelID = "com.example.vaccinationcovidhcarecentrenotification"


        val mChannel = NotificationChannel(channelID, "c", NotificationManager.IMPORTANCE_DEFAULT)
        mChannel.description = "d"

        var notification = Notification.Builder(
            this@SuccessBooking,
            "com.example.vaccinationcovidhcarecentrenotification"
        )
            .setContentText("Slot selection for vaccination is successfully completed")
            .setSmallIcon(R.drawable.ic_hospital).setChannelId(channelID)
        notification.setContentIntent(pendingIntent)
        val myNotification: Notification = notification.build()
        var mNotifyManager =
            this@SuccessBooking!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotifyManager.createNotificationChannel(mChannel)
        mNotifyManager.notify(notificationID, myNotification)
        Toast.makeText(this, "Successfully Booked", Toast.LENGTH_SHORT).show()


    }
    fun homepage(v: View?)
    {

        var i = Intent(application,MainActivity::class.java)
        startActivity(i)
    }


    }

