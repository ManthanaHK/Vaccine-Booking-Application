package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Precautionary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precautionary)
    }

    fun back(v: View?)
    {
        var i = Intent(application,HomeIsolation()::class.java)
        startActivity(i)
    }
}