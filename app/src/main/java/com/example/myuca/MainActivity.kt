package com.example.myuca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast


import com.android.volley.Response

import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data class Data(
            val idC: String,
            val nombres: String,
            val apellidos: String,
            val fechaNac: String,
            val titulo: String,
            val email: String,
            val facultad: String
        )

val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val url = "http://192.168.1.21/ManiJSON/mostrarMysql.php"
        val requestQueue = Volley.newRequestQueue(this)
        val stringRequest = MyStringRequest(url, Response.Listener<String> { response ->
            val jsonArray = JSONArray(response)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                    var text = jsonObject.toString()
                    tvResultado.text = jsonObject.toString()
                    Toast.makeText(applicationContext,text,Toast.LENGTH_LONG).show()

                }




        })
        requestQueue.add(stringRequest)
    }
}