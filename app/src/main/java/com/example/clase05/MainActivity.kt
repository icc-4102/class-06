package com.example.clase05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var covidRecyclerView: RecyclerView
    lateinit var adapter: CovidRecyclerViewAdapter
    lateinit var cases: Array<CovidCase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        covidRecyclerView = findViewById(R.id.covid_recycler_view)
        covidRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CovidRecyclerViewAdapter()
        adapter.onClickListener = this
        //Se designa el adaptador para la recyclerView
        covidRecyclerView.adapter = adapter
        //Libreria externa para transformar un json a data class
        val gson = Gson()
        cases = gson.fromJson(dataJson,Array<CovidCase>::class.java)

        //Boton que agrega un caso al recycler view
        val addCaseButton = findViewById<Button>(R.id.add_case_button)
        addCaseButton.setOnClickListener {
            adapter.addCase(cases[0])
//            // Metodo que lo ordena nuevamente, se utiliza para que no entregue el mismo siempre
            cases.shuffle()
        }
    }

    override fun onClickItem(item: Any) {
        if(item is CovidCase){
            val intent = Intent(this, CovidCaseDetail::class.java)
            val case = item as CovidCase
            //Esta es la forma correcta de pasar data por el intent. Lo que se vio en clase puede ser dependiendo del tipo
            intent.putExtra("covidCase",case)
            this.startActivity(intent)
        }
    }

}