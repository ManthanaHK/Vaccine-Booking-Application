package com.example.vaccinationandcovidhcarecentrenotification

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.firestore.core.View

class Entrypincode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrypincode)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun searchCenters(v: View?) {

        lateinit var pinCodeEdt: EditText
        pinCodeEdt = findViewById(R.id.EditPinCode)
        val pinCode = pinCodeEdt.text.toString()

        if (pinCode.length != 6) {
            Toast.makeText(this, "Please enter a valid pin code", Toast.LENGTH_SHORT).show()
        } else {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val dateStr: String = """$dayOfMonth/${month + 1}/$year"""
                    Toast.makeText(applicationContext,dateStr,Toast.LENGTH_LONG).show()
                    var i = Intent(application,Vaccinationcenterslist::class.java)
                    i.putExtra("pincode",pinCode)
                    i.putExtra("dt",dateStr)

                    startActivity(i)
                },
                year,
                month,
                day
            )
            dpd.show()
        }
    }
    fun back(v:View?)
    {
        var i = Intent(application,Vaccination::class.java)
        startActivity(i)
    }

}