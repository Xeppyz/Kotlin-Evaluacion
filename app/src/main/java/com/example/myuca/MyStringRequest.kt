package com.example.myuca

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class MyStringRequest(url: String, private val listener: Response.Listener<String>) : StringRequest(Method.GET, url, listener, null){
}