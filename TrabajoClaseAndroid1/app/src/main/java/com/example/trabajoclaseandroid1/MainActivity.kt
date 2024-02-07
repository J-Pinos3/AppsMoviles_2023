package com.example.trabajoclaseandroid1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var enableNavigation: CheckBox
    private lateinit var etUserInput: EditText
    private lateinit var navigatSecondActivity: Button
    private lateinit var showToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()

        enableNavigation.isEnabled = true
        enableNavigation.isChecked = false


        showToast.setOnClickListener {
            Toast.makeText(this@MainActivity,
                "Integrantes: David Basantes, Miguel Carapaz, José Pinos", Toast.LENGTH_LONG).show()
        }


        navigatSecondActivity.setOnClickListener {
            val intent = Intent(this, ActivitySecondary::class.java)
            val name: String = etUserInput.text.toString()
            intent.putExtra("nombre", name)
            startActivity(intent)
        }

    }



    private fun initUI(){
        enableNavigation =  findViewById(R.id.enableNavigation)
        etUserInput =   findViewById(R.id.etUserInput)
        navigatSecondActivity = findViewById(R.id.navigatSecondActivity)
        showToast = findViewById(R.id.showToast)
    }


    fun onCheckBoxClicked(view: View){
        if(view is CheckBox){
            var isChecked = view.isChecked
            when(view.id){
                R.id.enableNavigation -> {
                    if(isChecked){
                        navigatSecondActivity.isEnabled = true

                    }else{
                        navigatSecondActivity.isEnabled = false
                    }
                }
            }
        }
    }

}