package com.example.agendaesc

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendaesc.databinding.ActivityVerItemMateriaBinding
import com.example.agendaesc.databinding.ItemMateriaBinding

class ver_item_materia : AppCompatActivity() {

    private lateinit var binding_materia: ActivityVerItemMateriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_ver_item_materia)
        binding_materia = ActivityVerItemMateriaBinding.inflate(layoutInflater)
        setContentView(binding_materia.root)


        val idmateria = intent.getStringExtra("position")

        val admin = Database(this, "agendaEscolar", null, 1)
        val db = admin.writableDatabase

        if (db == null) {
            Toast.makeText(this, "No se pueden mostrar los datos", Toast.LENGTH_SHORT).show()
        } else {
            val cursor: Cursor = db.rawQuery("SELECT * FROM materias where '${idmateria.toString()}'==id_materia", null)
            Toast.makeText(this, "$cursor", Toast.LENGTH_SHORT).show()

             if (cursor.moveToFirst()) {
                     var nombreee = cursor.getString(cursor.getColumnIndex("nombre_materia"))
                     binding_materia.nombreMateria.setText(nombreee)
                     Toast.makeText(this, "Datos cargados", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "No se pueden cargar los datos ", Toast.LENGTH_SHORT).show()
            }
        }
        //Eliminar

        binding_materia.delete.setOnClickListener{
            val admin = Database(this, "prueba", null, 1)
            val db = admin.writableDatabase
            if (db == null){
                Toast.makeText(this, "No DB", Toast.LENGTH_SHORT).show()
            }
            else {
                val cnt = db.delete("personas", "nombre = '${idmateria.toString()}'", null)
                db.close()
                if (cnt ==1)
                    Toast.makeText(this, "Se borro el registro con exito ", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "No existe el registro ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

