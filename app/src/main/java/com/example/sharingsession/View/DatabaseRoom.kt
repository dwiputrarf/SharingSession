package com.example.sharingsession.View

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sharingsession.R
import com.example.sharingsession.db.Pekerjaan
import com.example.sharingsession.db.PekerjaanDatabase
import kotlinx.android.synthetic.main.activity_database_room.*

class DatabaseRoom : AppCompatActivity() {

    var dataArray = arrayListOf<String>()
    private var karyawanDatabase: PekerjaanDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_room)
        karyawanDatabase = PekerjaanDatabase.getDatabase(this)!!
        btnSave.setOnClickListener {
            if (!etEnterText.text.toString().isEmpty()) {
                val karyawanObj = Pekerjaan(etEnterText.text.toString())
                InsertTask(this, karyawanObj).execute()
            }
        }
        btnDisplay.setOnClickListener {
            GetDataFromDb(this).execute()
        }
        btnDelete.setOnClickListener{
            DeleteTask(this).execute()
        }
    }

    private class DeleteTask(var context: DatabaseRoom) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.karyawanDatabase!!.pekerjaanDao().deleteAll()
            return true
        }
        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Database GONE", Toast.LENGTH_LONG).show()
                context.dataArray.clear()
                var adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, context.dataArray)
                adapter.notifyDataSetChanged()
                context.tvDatafromDb.adapter = adapter
            }
        }
    }

    private class InsertTask(var context: DatabaseRoom, var karyawan: Pekerjaan) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.karyawanDatabase!!.pekerjaanDao().insert(karyawan)
            return true
        }
        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Added to Database", Toast.LENGTH_LONG).show()
            }
        }
    }
    private class GetDataFromDb(var context: DatabaseRoom) : AsyncTask<Void, Void, List<Pekerjaan>>() {
        override fun doInBackground(vararg params: Void?): List<Pekerjaan> {
            return context.karyawanDatabase!!.pekerjaanDao().getAllPekerjaan()
        }
        override fun onPostExecute(karyawanList: List<Pekerjaan>?) {
            context.dataArray.clear()
            if (karyawanList!!.size > 0) {
                for (i in 0..karyawanList.size - 1) {
                    context.dataArray.add(karyawanList[i].namaPekerjaan)
                }
                var adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, context.dataArray)
                adapter.notifyDataSetChanged()
                context.tvDatafromDb.adapter = adapter
            }
        }
    }
}
