package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Vaccination : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccination)
    }
    fun aboutvaccine(v: View?)
    {
        var i = Intent(application,AboutVaccine()::class.java)
        startActivity(i)
    }

    fun bookslot(v:View?)
    {
        var i = Intent(application,Entrypincode()::class.java)
        startActivity(i)
    }


    fun back(v:View?)
    {
        var i = Intent(application,MainActivity::class.java)
        startActivity(i)
    }
     fun seebooking(v:View?)
     {
         var i = Intent(application,BookingDetails::class.java)
         startActivity(i)
     }
}