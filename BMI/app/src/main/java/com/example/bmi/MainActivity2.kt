package com.example.bmi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        loadData()

        button2.setOnClickListener { view ->
            if (addHeight.text.isEmpty() || addHeight.text.toString().toFloat() <=0F){
                Toast.makeText(applicationContext, "Enter valid height!", Toast.LENGTH_SHORT).show()
            } else {
                saveData()
                val intent = Intent()
                        .putExtra("joku", addHeight.text.toString().toFloat())
                setResult(1, intent)
                finish()
            }
        }



    }

    fun saveData() {
        val height = addHeight.text.toString().toFloat()
        val sp =  getSharedPreferences("bmi", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.apply{
            putFloat("height", height)
        }.apply()

    }

    fun loadData () {
        val sp = getSharedPreferences("bmi",Context.MODE_PRIVATE)
        var height = sp.getFloat("height", 1.8F)
        textView6.text = " Your height: $height m"
    }
}