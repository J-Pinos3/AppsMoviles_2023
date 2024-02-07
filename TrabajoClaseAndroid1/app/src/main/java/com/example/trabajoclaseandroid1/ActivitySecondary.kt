package com.example.trabajoclaseandroid1

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivitySecondary : AppCompatActivity() {

    private lateinit var tvUserName: TextView
    private lateinit var btnSaveUserData: Button

    private lateinit var lvStringsValues: RecyclerView
    private val itemsStringNames = listOf("Manzana","Pera","Banano","Piña","Sandía", "Guanabana", "Melon", "")
    private lateinit var myListAdapter: ListAdapter
    private val KEY:String = "DATA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        initUI()

        val name: String = intent.extras?.getString("nombre").toString()
        tvUserName.text = name

        myListAdapter = ListAdapter(itemsStringNames)
        lvStringsValues.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lvStringsValues.adapter = myListAdapter

        btnSaveUserData.setOnClickListener {
            saveItemsToFile(KEY)
        }

    }


    private fun initUI(){
        tvUserName = findViewById(R.id.tvUserName)
        btnSaveUserData = findViewById(R.id.btnSaveUserData)

        lvStringsValues = findViewById(R.id.lvStringsValues)
    }


    private fun saveItemsToFile(key:String){
        val sharedPreferences: SharedPreferences = getSharedPreferences(key, MODE_PRIVATE)

        val editor= sharedPreferences.edit()
        editor.putString("USER-NAME", tvUserName.text.toString())
        editor.apply()
    }

}