package com.example.agendaesc

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaesc.databinding.ItemMateriaBinding
import com.example.agendaesc.databinding.ItemTareasBinding

class TareasAdapter(val list_tareas: ArrayList<ItemTareas>, val listener:MyonClickListener):RecyclerView.Adapter<TareasAdapter.MyViewHolderTask>() {

    inner class MyViewHolderTask(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bindingTareas = ItemTareasBinding.bind(itemView)
        val TituloTarea: TextView = bindingTareas.TituloTarea
        val DescripcionTarea: TextView = bindingTareas.descripcionTarea

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                listener.OnClick(position)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTask {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolderTask (inflater.inflate(R.layout.item_tareas, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolderTask, position: Int) {
        val item = list_tareas[position]

          holder.TituloTarea.text = item.TituloTarea
           holder. DescripcionTarea.text = item.DescripcionTarea
        }


    override fun getItemCount(): Int {
        return list_tareas.size
    }

    interface MyonClickListener{
        fun OnClick(
            position: Int
        )
    }
}
