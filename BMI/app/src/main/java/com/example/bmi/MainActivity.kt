package com.example.bmi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp = getSharedPreferences("bmi",Context.MODE_PRIVATE)
        val height = sp.getFloat("height", 1.8F)

        val sp2 = getSharedPreferences("all",Context.MODE_PRIVATE)
        textView5.text="Your height: $height m"

        button3.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, MainActivity3::class.java)
            startActivity(intent)
        }
        val lista = mutableListOf<Float>()

        button.setOnClickListener { view ->

            if (addWeight.text.isEmpty() || addWeight.text.toString().toFloat() <= 0F){
                Toast.makeText(applicationContext, "Enter valid weight!", Toast.LENGTH_SHORT).show()
            } else {

                val weight = addWeight.text.toString().toFloat()
                val result = weight / (height * height)

                lista.add(result)

                for ((index, value) in lista.withIndex()) {
                    val editor = sp2.edit()
                    editor.apply{
                        putFloat("$index", value)
                    }.apply()
                }

                textView.text = "Your BMI: " + "%.2f".format(result)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sp = getSharedPreferences("bmi",Context.MODE_PRIVATE)
        val height = sp.getFloat("height", 1.8F)
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putExtra("joku", height)
        startActivityForResult(intent, 1)
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data!=null){
            textView5.text = "Your height: ${data?.getFloatExtra("joku", 1.8F)} m"
        } else {
            val sp = getSharedPreferences("bmi",Context.MODE_PRIVATE)
            val height = sp.getFloat("height", 1.8F)
            textView5.text="Your height: $height m"
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}