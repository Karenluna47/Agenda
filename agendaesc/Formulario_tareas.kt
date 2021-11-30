package com.example.agendaesc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendaesc.databinding.ActivityFormularioTareasBinding

class Formulario_tareas : AppCompatActivity() {

    private lateinit var bindtask : ActivityFormularioTareasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindtask = ActivityFormularioTareasBinding.inflate(layoutInflater)
        setContentView(bindtask.root)


        bindtask.btnNew.setOnClickListener {
            Toast.makeText(this, "Pruebaaaa", Toast.LENGTH_SHORT).show()
        }
    }
}