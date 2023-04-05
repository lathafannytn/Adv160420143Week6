package com.ubaya.adv160420143week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160420143week4.R
import com.ubaya.adv160420143week4.model.Student
import com.ubaya.adv160420143week4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*


class StudentListAdapter(val studenList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    class StudentViewHolder(var view: View) :RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studenList[position]
        val txtId = holder.view.findViewById<TextView>(R.id.txtID)
        txtId.text = studenList[position].id

        val txtName = holder.view.findViewById<TextView>(R.id.txtName)
        txtName.text = studenList[position].name

        holder.view.imageView.loadImage(studenList[position].photoUrl.toString(), holder.view.progressBar )

        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        btnDetail.setOnClickListener {
            val action = student.id?.let{ id ->
                StudentListFragmentDirections.actionStudentDetail(id)
            }
            if (action != null)
            {
                Navigation.findNavController(it).navigate(action)
            }
            //val action = StudentListFragmentDirections.actionStudentDetail()
            //Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return studenList.size
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

}