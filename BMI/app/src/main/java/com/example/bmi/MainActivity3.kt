package com.example.bmi

import android.app.ActionBar
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        val sp = getSharedPreferences("all", Context.MODE_PRIVATE)
        val luku = sp.all.size

        val graph = findViewById<View>(R.id.graph) as GraphView
        val series: BarGraphSeries<DataPoint> = BarGraphSeries()

        var x = 0
        while (x<luku){
            series.appendData(DataPoint(x.toDouble(), sp.getFloat("$x", 10F).toDouble()), false, 40)
            x++
        }

        graph.addSeries(series)

        button4.setOnClickListener { view ->
            sp.edit().clear().apply()
        }

    }


}