package com.example.vaccinationandcovidhcarecentrenotification

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class BookingDetails : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var mFirebaseDatabaseInstances: FirebaseFirestore? = null
    lateinit var cv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccinationcenterslist)
        //Get Firebase Instances
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        mAuth = FirebaseAuth.getInstance()
        mFirebaseDatabaseInstances = FirebaseFirestore.getInstance()
        cv = findViewById<View>(R.id.RVBooking) as RecyclerView
        loadData()

    }

    fun loadData() {
        val query: Query = FirebaseFirestore.getInstance()
            .collection("booking")
        val options: FirestoreRecyclerOptions<Booking?> =
            FirestoreRecyclerOptions.Builder<Booking>()
                .setQuery(query, Booking::class.java)
                .build()
        val adapter: FirestoreRecyclerAdapter<*, *> = object :
            FirestoreRecyclerAdapter<Booking?,
                    RecyclerView.ViewHolder>(options) {
            override fun onCreateViewHolder(
                group: ViewGroup, i:
                Int
            ): BookingHolder {
// Using a custom layout called R.layout.message for each item, we create a new instance of the viewholder
                val view: View = LayoutInflater.from(group.context)
                    .inflate(R.layout.booking, group, false)
                return BookingHolder(view)
            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun onBindViewHolder(
                holder: RecyclerView.ViewHolder,
                position: Int,
                model: Booking
            ) {

                (holder.itemView.findViewById<View>(R.id.txtphone) as
                        TextView).setText("Booking Number: " + model.BookingNumber)
                (holder.itemView.findViewById<View>(R.id.slot) as
                        TextView).setText("Selected Slot:" + model.Slot)
                (holder.itemView.findViewById<View>(R.id.date) as
                        TextView).setText("Selected Date:" + model.Date)
                (holder.itemView.findViewById<View>(R.id.BOOK)).setOnClickListener()
                {

                    var i = intent
                    var BookingNumber = model.BookingNumber
                    var Slot = model.Slot
                    var Date = model.Date
                    //val sdf = SimpleDateFormat("dd-MM-yyyyhh:mm:ss")
                    //val date = sdf.format(DateFormat())
                    var b = Booking(BookingNumber, Slot,Date)
                    val docRef = mFirebaseDatabaseInstances?.collection("booking")?.document(Slot!!)
                    docRef?.get()?.addOnSuccessListener { documentSnapshot ->
                        mFirebaseDatabaseInstances?.collection("booking")?.document(Slot!!)?.set(b)
                    }

                }
            }
        }
        cv.layoutManager = LinearLayoutManager(this)
        cv.adapter = adapter
        adapter.startListening()
    }


    fun back(v: View?) {
        var i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}


        class Booking {
            var BookingNumber = 0
            var Slot = ""
            var Date = ""

            constructor(BookingNumber: Int, Slot: String, Date: String) {
                this.BookingNumber = BookingNumber
                this.Slot = Slot
                this.Date = Date
            }

            constructor()
        }


        class BookingHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        {

        val BookingNumber: TextView
        val Slot: TextView
        val Date: TextView

            init {
            BookingNumber = itemView.findViewById(R.id.bookingnumber)
            Slot = itemView.findViewById(R.id.slot)
            Date = itemView.findViewById(R.id.date)
        }

    }



