package com.example.agendaesc

import ItemMateria
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaesc.databinding.ItemMateriaBinding


class MateriaAdapter(val list: ArrayList<ItemMateria>, val listener: MyonclickListener): RecyclerView.Adapter<MateriaAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val bindingItems = ItemMateriaBinding.bind(itemView)
        val NombreMateria: TextView = bindingItems.NombreMateria
        val NombreMaestro: TextView = bindingItems.NombreMaestro

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                listener.OnClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_materia, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]

        holder.NombreMateria.text = item.NombreMateria
        holder.NombreMaestro.text = item.NombreProfesor
    }

    override fun getItemCount(): Int {
        return list.size
    }


    interface MyonclickListener {
        fun OnClick(
            position: Int,
        )

    }
}