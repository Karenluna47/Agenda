package com.example.agendaesc

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int):
    SQLiteOpenHelper(context, name, factory, version){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table materias( id_materia primary key, nombre_materia text, nombre_maestros text , acronimo text, link_materia text)")
        db?.execSQL("Create table tareas(id_tarea primary key, titulo_tarea text, descripcion_tarea text, fecha_entrega text, hora_entrega text)")
       // db?.execSQL("Alter Table materias Add column nombre_maestros")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("Drop table if exists materias")
        db?.execSQL("Drop table if exists tareas")

    }
}