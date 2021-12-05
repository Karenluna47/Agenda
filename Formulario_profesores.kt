package com.example.agendaesc

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.agendaesc.databinding.ActivityFormProfesoresBinding
import com.example.agendaesc.databinding.ActivityFormularioBinding

class Formulario_profesores : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_profesores)
        val binpro = ActivityFormProfesoresBinding.inflate(layoutInflater)
        setContentView(binpro.root)

//Insercion
     /*   binpro.button2.setOnClickListener {
            val admin = Database(this, "prueba", null, 1)
            val db = admin.writableDatabase
            val record = ContentValues()
            record.put("id_materia", binpro.idMateria.text.toString())
            record.put("nombre_materia", binpro.nombreM.text.toString())
            record.put("acronimo", binpro.acronimoM.text.toString())
            record.put("link_materia", binpro.urlM.text.toString())
            db.insert("materia", null, record)
            db.close()
            Toast.makeText(this, "Se cargaron los datos de la materia", Toast.LENGTH_SHORT).show()
        }*/
    }
}