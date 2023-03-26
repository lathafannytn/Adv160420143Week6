package com.ubaya.adv160420143week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.adv160420143week4.model.Student

class DetailViewModel {
    val studentLiveData = MutableLiveData<Student>()
//    private var queue: RequestQueue? = null

    fun fetch(){
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLiveData.value = student1
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "student.php?id=$id"
//        val stringRequest = StringRequest(
//            Request.Method.GET, url, {
//                val result = Gson().fromJson(it, Student::class.java)
//                studentLiveData.value = result
//                Log.d("showvolley", it)
//            },{
//                Log.d("errorvolley", it.toString())
//            }
//        ).apply {
//            tag = "volleyTag"
//        }
//        queue?.add(stringRequest)
    }

}