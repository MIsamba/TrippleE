package com.globomed.learn

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.globalmed.Employee
import com.example.globalmed.R
import kotlinx.android.synthetic.main.list_item.view.*

class EmployeeListAdapter(
	private val context: Context
) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>() {

	lateinit var employeeList: ArrayList<Employee>

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): EmployeeViewHolder {

		val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
		return EmployeeViewHolder(itemView)
	}

	override fun getItemCount(): Int = employeeList.size



	override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {

		val employee = employeeList[position]
		holder.setData(employee.name, employee.designation)

	}

	fun setEmployees(employees: ArrayList<Employee>) {

		  employeeList = employees
		  notifyDataSetChanged() 
	}

	class EmployeeViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView) {

		fun setData(name: String, designation: String) {
			itemView.tvEmpName.text = name
			itemView.tvEmpDesignation.text = designation

		}
	}
}
