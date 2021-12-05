package com.example.agendaesc

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaesc.databinding.ActivityVistaTareasBinding
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsTools

class vista_tareas : AppCompatActivity(), TareasAdapter.MyonClickListener {
    private lateinit var bintask : ActivityVistaTareasBinding
    private lateinit var rcv_task: RecyclerView
    private var list_tareas: ArrayList<ItemTareas> = ArrayList()
    private var rcvAdapter = TareasAdapter(list_tareas, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bintask = ActivityVistaTareasBinding.inflate(layoutInflater)
        setContentView(bintask.root)
        rcv_task = bintask.recyclerTareas

        HiAnalyticsTools.enableLog()
        val instance = HiAnalytics.getInstance(applicationContext);



        bintask.btnAddTask.setOnClickListener {
            //Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show()
            var int: Intent = Intent(this, Form_tareas::class.java)
            int.putExtra("nombre", "Karen")
            startActivity(int)
            val bundle = Bundle()
            bundle.putString("pt2", "high")
            bundle.putString("exam_level", "1-1")
            bundle.putString("exam_time", "20190520-08")
            instance.onEvent("btn", bundle)
        }

        val admin = Database(this, "agendaEscolar", null, 1)
        val db = admin.readableDatabase

        val cursor: Cursor = db.rawQuery("SELECT * FROM tareas", null)

        rcv_task.apply {
            layoutManager =LinearLayoutManager(this@vista_tareas)
            adapter = rcvAdapter
        }

        bintask.recyclerTareas.setHasFixedSize(true)

        rcvAdapter.notifyDataSetChanged();

        if (cursor.moveToNext()){
            var TituloTask: String = cursor.getString(cursor.getColumnIndex("titulo_tarea"))
            var DescripcionTask: String = cursor.getString(cursor.getColumnIndex("descripcion_tarea"))
            val TaskModel = ItemTareas(TituloTarea = TituloTask, DescripcionTarea = DescripcionTask)
            list_tareas.add(TaskModel)
            rcvAdapter.notifyDataSetChanged();
        } else{
            Toast.makeText(this, "No se insertaron datos", Toast.LENGTH_SHORT).show()
        }




    }

    override fun OnClick(position: Int) {
      // Toast.makeText(this, "Esto es:${list_tareas[position]}", Toast.LENGTH_SHORT).show()
        var int = Intent(this, ver_item_tareas::class.java)
        int.putExtra("position", position)
        startActivity(int)
    }
}