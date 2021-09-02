package com.example.vaccinationandcovidhcarecentrenotification


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsMessage
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.System.exit

class EntryDetails : AppCompatActivity() {
    var agenum = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrydetails)
    }

    @RequiresApi(Build.VERSION_CODES.N)
     fun selectDate(v:View?) {
        val c = Calendar.getInstance()
        var cyear = c.get(Calendar.YEAR)
        var cmonth = c.get(Calendar.MONTH)
        var cday = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                cyear = year
                cmonth = month
                cday = dayOfMonth
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                var agecondition = currentYear - cyear
                Toast.makeText(this, "Your age is : $agecondition", Toast.LENGTH_LONG).show()

                val dob = findViewById<TextView>(R.id.birthdate)
                dob.setText(" Your age is: " +"$agecondition"+"                click here to reset").toString()
                val dobValue = dob.text

                agenum = "$agecondition"
            },
            cyear,
            cmonth,
            cday
        )
        dpd.show()
    }

    fun back(v: View?) {
        var i = Intent(application, SlotSelection::class.java)
        startActivity(i)
    }


    fun done(v: View?)
    {

        if(agenum <="18")
        {
            Toast.makeText(this, "Your age is not suitable for vaccination", Toast.LENGTH_LONG).show()
        }

        else
        {
            var i = Intent(application,SuccessBooking()::class.java)
            startActivity(i)
        }
    }
}

