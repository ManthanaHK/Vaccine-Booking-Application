package com.example.vaccinationandcovidhcarecentrenotification

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query



class Vaccinationcenterslist : AppCompatActivity() {
    private var mAuth: FirebaseAuth?=null
    private var mFirebaseDatabaseInstances: FirebaseFirestore?=null
    lateinit var cv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccinationcenterslist)
        //Get Firebase Instances
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        mAuth=FirebaseAuth.getInstance()
        mFirebaseDatabaseInstances= FirebaseFirestore.getInstance()
        cv=findViewById<View>(R.id.RVcenters) as RecyclerView
        loadData()

    }

    fun loadData()
    {




        mFirebaseDatabaseInstances!!.collection("pin1")
            .whereEqualTo("date",true).get()
            .addOnSuccessListener{ documents ->
                for(document in documents){
                    Log.d(TAG,"${document.id}=>${document.data}")
                }
            }
            .addOnFailureListener{exception ->
                Log.w(TAG,"Error getting documents:",exception)
            }

        mFirebaseDatabaseInstances!!.collection("pin1").get()
            .addOnSuccessListener{ documents ->
                for(document in documents){
                    Log.d(TAG,"${document.id}=>${document.data}")
                }
            }
            .addOnFailureListener{exception ->
                Log.w(TAG,"Error getting documents:",exception)
            }


        var i=intent
        var pincode=i.getStringExtra("pincode")
        var dt=i.getStringExtra("dt")

        val query: Query = FirebaseFirestore.getInstance()
            .collection("pin1").whereEqualTo("pincode",pincode).whereEqualTo("dt",dt)
        val options: FirestoreRecyclerOptions<Center?> =
            FirestoreRecyclerOptions.Builder<Center>()
                .setQuery(query, Center::class.java)
                .build()
        val adapter: FirestoreRecyclerAdapter<*, *> = object :
            FirestoreRecyclerAdapter<Center?,
                    RecyclerView.ViewHolder>(options) {
            override fun onCreateViewHolder(group: ViewGroup, i:
            Int): CenterHolder {
// Using a custom layout called R.layout.message for each item, we create a new instance of the viewholder
                val view: View = LayoutInflater.from(group.context)
                    .inflate(R.layout.center, group, false)
                return CenterHolder(view)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, model: Center) {
                (holder.itemView.findViewById<View>(R.id.TVCenterName) as
                        TextView).setText("Center Name: " +model.CenterName)
                (holder.itemView.findViewById<View>(R.id.TVCenterLocation) as
                        TextView).setText("Center Location:" +model.CenterLocation)
                (holder.itemView.findViewById<View>(R.id.TVCenterTimings) as
                        TextView).setText("Center Timings:"+model.CenterTimings.toString())
                (holder.itemView.findViewById<View>(R.id.TVVaccineName) as
                        TextView).setText("Vaccine Name:"+model.VaccineName)
                (holder.itemView.findViewById<View>(R.id.TVVaccineFees) as
                        TextView).setText("Vaccine Fees:"+model.VaccineFees)
                (holder.itemView.findViewById<View>(R.id.TVAgeLimit) as
                        TextView).setText("Age Limit:"+model.AgeLimit)
                (holder.itemView.findViewById<View>(R.id.TVAvailability) as
                        TextView).setText("Availability:"+model.Availability)
            }

        }
        cv.layoutManager = LinearLayoutManager(this)
        cv.adapter=adapter
        adapter.startListening()
    }

    fun back(v:View?){
        var i = Intent(this, Entrypincode::class.java)
        startActivity(i)
    }
    fun select(v:View?)
    {
        var i = Intent(this, SlotSelection::class.java)
        startActivity(i)
    }

}

class Center {
    var CenterName=""
    var CenterLocation=""
    var CenterTimings=""
    var VaccineName=""
    var VaccineFees=""
    var AgeLimit=""
    var Availability=0

    constructor(CenterName:String,CenterLocation:String,CenterTimings:String,VaccineName:String,VaccineFees:String,AgeLimit:String,Availability:Int)
    {
        this.CenterName=CenterName
        this.CenterLocation=CenterLocation
        this.CenterTimings=CenterTimings
        this.VaccineName=VaccineName
        this.VaccineFees=VaccineFees
        this.AgeLimit=AgeLimit
        this.Availability=Availability
    }
    constructor()
}
class CenterHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val CenterName: TextView
    val CenterLocation: TextView
    val CenterTimings: TextView
    val VaccineName:TextView
    val VaccineFees:TextView
    val AgeLimit:TextView
    val Availability:TextView
    init {

        CenterName=itemView.findViewById(R.id.TVCenterName)
        CenterLocation=itemView.findViewById(R.id.TVCenterLocation)
        CenterTimings=itemView.findViewById(R.id.TVCenterTimings)
        VaccineName=itemView.findViewById(R.id.TVVaccineName)
        VaccineFees=itemView.findViewById(R.id.TVVaccineFees)
        AgeLimit=itemView.findViewById(R.id.TVAgeLimit)
        Availability=itemView.findViewById(R.id.TVAvailability)

    }
}