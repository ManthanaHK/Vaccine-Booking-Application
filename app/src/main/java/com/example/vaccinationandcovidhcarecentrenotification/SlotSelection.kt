package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class SlotSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_selection)
    }

    fun book(v: View?) {

            var i = Intent(application, EntryDetails::class.java)
            startActivity(i)
        }



        fun back(v: View?) {
            var i = Intent(application, Vaccinationcenterslist::class.java)
            startActivity(i)
        }
    }
