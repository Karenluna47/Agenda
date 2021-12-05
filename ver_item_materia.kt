package com.example.agendaesc

import android.content.ContentValues
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendaesc.databinding.ActivityVerItemMateriaBinding

class ver_item_materia : AppCompatActivity() {

    private lateinit var binding_materia: ActivityVerItemMateriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_ver_item_materia)
        binding_materia = ActivityVerItemMateriaBinding.inflate(layoutInflater)
        setContentView(binding_materia.root)

        //val idmateria = intent.getIntExtra("position", 0)



        val admin = Database(this, "agendaEscolar", null, 1)
        val db = admin.writableDatabase

        if (db == null) {
            Toast.makeText(this, "No se pueden mostrar los datos", Toast.LENGTH_SHORT).show()
        } else {
            val cursor = db.rawQuery("SELECT * FROM materias", null)

            if (cursor.moveToNext()) {
                var nombre = cursor.getString(cursor.getColumnIndex("nombre_materia"))
                binding_materia.nombreMateria.setText(nombre)
                var profesor = cursor.getString(cursor.getColumnIndex("nombre_maestros"))
                binding_materia.nombreMtro.setText(profesor)
                var acronimo = cursor.getString(cursor.getColumnIndex("acronimo"))
                binding_materia.acronimoMateria.setText(acronimo)
                var linkclase = cursor.getString(cursor.getColumnIndex("link_materia"))
                binding_materia.linkMateria.setText(linkclase)

                Toast.makeText(this, "Datos cargados", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "No se pueden cargar los datos ", Toast.LENGTH_SHORT).show()
            }
        }


        //Eliminar

        binding_materia.delete.setOnClickListener {
            val admin = Database(this, "agendaEscolar", null, 1)
            val db = admin.writableDatabase
            if (db == null) {
                Toast.makeText(this, "No DB", Toast.LENGTH_SHORT).show()
            } else {
                val cnt = db.delete("materias", "nombre_materia = '${binding_materia.nombreMateria.text.toString()}'", null)
                db.close()
                if (cnt == 1)
                    Toast.makeText(this, "Se borro el registro con exito ", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "No existe el registro ", Toast.LENGTH_SHORT).show()
            }
        }

        // Actualizar
        binding_materia.editButton.setOnClickListener {
            val admin = Database(this, "agendaEscolar", null, 1)
            val db = admin.writableDatabase
            val record = ContentValues()
            record.put("nombre_materia", binding_materia.nameMateria.text.toString())
            record.put("nombre_maestros", binding_materia.nombreMtro.text.toString())
            record.put("acronimo", binding_materia.acronimoMateria.text.toString())
            record.put("link_materia", binding_materia.linkMateria.toString())
            val cant = db.update("materias", record, "nombre_materia ='${binding_materia.nombreMateria.text.toString()}'", null)
            db.close()
            Toast.makeText(this, "${cant}", Toast.LENGTH_SHORT).show()
            if (cant == 1) {
                Toast.makeText(this, "Se actualizo el registro con exito", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No existe el registro", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


