package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Prescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prescription)
    }
    fun zincsulphate(v: View?)
    {
        var i = Intent(application,TabletDetailsZincSulphate::class.java)
        startActivity(i)
    }

    fun vitaminc(v: View?)
    {
        var i = Intent(application,TabetDetailsVitaminC::class.java)
        startActivity(i)
    }

    fun doxycycline(v:View?)
    {
        var i = Intent(application,TabletDetailsDoxyCycline::class.java)
        startActivity(i)
    }

    fun back(v:View?)
    {
        var i = Intent(application,HomeIsolation()::class.java)
        startActivity(i)
    }
}