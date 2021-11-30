package com.example.agendaesc

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendaesc.databinding.ActivityFormTareasBinding
import com.example.agendaesc.databinding.ActivityFormularioBinding

class Form_tareas : AppCompatActivity() {
    private lateinit var binding_tareas: ActivityFormTareasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_tareas = ActivityFormTareasBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_form_tareas)


       //Insercion
        binding_tareas.btnTask.setOnClickListener {
            val admin = Database(this, "agendaEscolar", null, 1)
            val db = admin.writableDatabase
            val record = ContentValues()
           // record.put( "id_tarea", binding_tareas..text.toString())
            record.put( "titulo_tarea", binding_tareas.tituloTarea.text.toString())
            record.put( "descripcion_tarea", binding_tareas.descripcionTareas.text.toString())
            record.put("fecha_entrega", binding_tareas.fechaTarea.text.toString())
            record.put("hora_entrega", binding_tareas.horaTarea.text.toString())
            //db.execSQL("SELECT * FROM tareas")
            db.insert("tareas", null, record)
            db.close()
            Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show()
        }
    }
}