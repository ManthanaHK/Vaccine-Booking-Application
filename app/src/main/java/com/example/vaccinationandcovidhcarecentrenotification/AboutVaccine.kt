package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutVaccine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_vaccine)
    }
    fun back(v: View?)
    {
        var i = Intent(application,Vaccination::class.java)
        startActivity(i)
    }
}