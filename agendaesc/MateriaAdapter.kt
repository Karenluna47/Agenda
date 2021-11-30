package com.example.agendaesc

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaesc.databinding.ItemMateriaBinding


class MateriaAdapter: RecyclerView.Adapter<MateriaAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var cursor: Cursor


    fun RecyclerViewMateriaAdapter(context: Context, cursor: Cursor) {
        this.context = context
        this.cursor = cursor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_materia, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        cursor.moveToPosition(position)

        holder.NombreMateria.text = cursor.getString(1)
        holder.NombreMaestro.text = cursor.getString(2)
    }

    override fun getItemCount(): Int {
        if (cursor == null)
            return 0
        else
            return cursor.count
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        val id_materia: TextView
        val NombreMateria: TextView
        val NombreMaestro: TextView

        constructor(view: View) : super(view) {

            val bindingItems = ItemMateriaBinding.bind(itemView)
            id_materia = bindingItems.idmateria
            NombreMateria = bindingItems.NombreMateria
            NombreMaestro = bindingItems.NombreMaestro


            view.setOnClickListener {
                Toast.makeText(context, "${NombreMateria.text}, $id_materia", Toast.LENGTH_SHORT).show()
                var int: Intent = Intent(context, ver_item_materia::class.java)
                int.putExtra("position", id_materia.text.toString())
                startActivity(context, int, Bundle())
            }
        }
    }
}
