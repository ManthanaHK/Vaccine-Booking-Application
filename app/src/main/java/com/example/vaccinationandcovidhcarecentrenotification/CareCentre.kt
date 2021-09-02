package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CareCentre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_centre)
    }

    fun back(v : View?)
    {
        var i = Intent(application,MainActivity()::class.java)
        startActivity(i)
    }



    fun homeisolation(v :View?)
    {
        var i = Intent(application,HomeIsolation()::class.java)
        startActivity(i)
    }

    fun contactdoctors(v: View?)
    {
        var i = Intent(application,ContactDoctors::class.java)
        startActivity(i)
    }
}