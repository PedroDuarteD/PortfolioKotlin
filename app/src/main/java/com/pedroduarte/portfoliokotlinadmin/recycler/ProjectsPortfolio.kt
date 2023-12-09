package com.pedroduarte.portfoliokotlinadmin.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import com.pedroduarte.portfoliokotlinadmin.R
import com.pedroduarte.portfoliokotlinadmin.model.ProjectModel

class ProjectsPortfolio(private val list: ArrayList<ProjectModel>, private val listener: OnEventListener)  : RecyclerView.Adapter<ProjectsPortfolio.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{

        val txt_name = itemView.findViewById<TextView>(R.id.txt_name)
        val txt_desc = itemView.findViewById<TextView>(R.id.txt_desc)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
           listener.OnItemClick(adapterPosition)
        }


    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsPortfolio.ViewHolder {
       val menu = LayoutInflater.from(parent.context).inflate(R.layout.view_project_card, parent, false)
           return ViewHolder(menu)
    }

    override fun onBindViewHolder(holder: ProjectsPortfolio.ViewHolder, position: Int) {
        val model = list.get(position)
        holder.txt_name.setText(model.nome)
        holder.txt_desc.setText(model.desc)
    }

    override fun getItemCount(): Int {
       return list.size
    }
 interface OnEventListener{
     fun OnItemClick(position: Int);
 }
}