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

class TareasAdapter:RecyclerView.Adapter<TareasAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var cursor: Cursor

    fun RecyclerViewTareasAdapter(context: Context, cursor: Cursor){
        this.context = context
        this.cursor = cursor
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_tareas, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        cursor.moveToPosition(position)
        holder.Titulo_tarea.text = cursor.getString(1)
        holder.Descripcion_tarea.text = cursor.getString(2)
    }

    override fun getItemCount(): Int {
        if (cursor == null)
            return 0
        else
            return cursor.count
    }
    inner class  ViewHolder: RecyclerView.ViewHolder{

        //val IdMateria : TextView
        val Titulo_tarea : TextView
        val Descripcion_tarea : TextView


        constructor(view: View): super(view) {

            val bindingItems = ItemTareasBinding.bind(itemView)
            Titulo_tarea = bindingItems.TituloTarea
            Descripcion_tarea = bindingItems.descripcionTarea

            view.setOnClickListener {
                Toast.makeText(context, "${Titulo_tarea.text}", Toast.LENGTH_SHORT).show()
            }

        }
    }
}