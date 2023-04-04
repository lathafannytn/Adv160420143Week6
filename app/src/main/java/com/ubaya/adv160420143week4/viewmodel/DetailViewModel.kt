package com.ubaya.adv160420143week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.adv160420143week4.model.Student

public class DetailViewModel: ViewModel() {
    val studentLiveData = MutableLiveData<Student>()

    fun fetch(){
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLiveData.value = student1
    }

}