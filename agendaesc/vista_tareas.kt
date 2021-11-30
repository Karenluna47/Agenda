package com.example.agendaesc

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendaesc.databinding.ActivityVistaTareasBinding
import com.huawei.hms.analytics.bi

class vista_tareas : AppCompatActivity() {
    private lateinit var bintask : ActivityVistaTareasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bintask = ActivityVistaTareasBinding.inflate(layoutInflater)
        setContentView(bintask.root)



        bintask.btnAddTask.setOnClickListener {
            Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show()
            var int: Intent = Intent(this, Form_tareas::class.java)
            int.putExtra("nombre", "Karen")
            startActivity(int)
        }

        val admin = Database(this, "agendaEscolar", null, 1)
        val db = admin.readableDatabase

        val cursor: Cursor = db.rawQuery("SELECT * FROM tareas", null)

        val adaptador = TareasAdapter()
        adaptador.RecyclerViewTareasAdapter(this, cursor)

        bintask.recyclerTareas.setHasFixedSize(true)
        bintask.recyclerTareas.layoutManager = LinearLayoutManager(this)
        bintask.recyclerTareas.adapter = adaptador



    }
}