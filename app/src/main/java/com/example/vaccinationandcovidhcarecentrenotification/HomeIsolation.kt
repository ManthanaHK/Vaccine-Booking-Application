package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeIsolation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_isolation)
    }
    fun prescription(v : View?)
    {
        var i = Intent(application,Prescription()::class.java)
        startActivity(i)
    }

    fun precautions(v : View?)
    {
        var i = Intent(application,Precautionary()::class.java)
        startActivity(i)
    }

    fun back(v: View?)
    {
        var i = Intent(application,CareCentre()::class.java)
        startActivity(i)
    }
}