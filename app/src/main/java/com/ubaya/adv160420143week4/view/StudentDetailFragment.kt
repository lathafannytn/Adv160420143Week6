package com.ubaya.adv160420143week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.ubaya.adv160420143week4.R
import com.ubaya.adv160420143week4.viewmodel.DetailViewModel
import com.ubaya.adv160420143week4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: ListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView.layoutManager = LinearLayoutManager(context)
        //recView.adapter = studentListAdapter
        refreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {

            var txtID = view.findViewById<TextInputEditText>(R.id.txtID)
            var txtName = view.findViewById<TextInputEditText>(R.id.txtName)
            var txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
            var txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)

            txtID.setText(it.id.toString())
            txtName.setText(it.name.toString())
            txtBod.setText(it.dob.toString())
            txtPhone.setText(it.phone.toString())
        })
    }

}


