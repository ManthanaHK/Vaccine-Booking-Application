package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun exit(v:View?)
    {

    }

    fun vaccination(v: View?)
    {
        var i = Intent(application,Vaccination::class.java)
        startActivity(i)
    }

    fun carecentre(v: View?)
    {
        var i = Intent(application,CareCentre::class.java)
        startActivity(i)
    }


}