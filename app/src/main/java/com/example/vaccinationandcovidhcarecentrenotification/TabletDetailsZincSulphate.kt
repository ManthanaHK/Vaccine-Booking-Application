package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TabletDetailsZincSulphate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablet_details_zinc_sulphate)
    }
    fun back(v: View?)
    {
        var i = Intent(application,Prescription()::class.java)
        startActivity(i)
    }
}