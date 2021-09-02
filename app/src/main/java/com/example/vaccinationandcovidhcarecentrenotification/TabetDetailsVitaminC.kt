package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TabetDetailsVitaminC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabet_details_vitamin_c)
    }
    fun back(v: View?)
    {
        var i = Intent(application,Prescription()::class.java)
        startActivity(i)
    }
}