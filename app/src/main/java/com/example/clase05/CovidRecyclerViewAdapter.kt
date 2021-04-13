package com.example.clase05

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CovidRecyclerViewAdapter():
        RecyclerView.Adapter<CovidRecyclerViewAdapter.CovidViewHolder>() {

    var data = mutableListOf<CovidCase>()
    lateinit var onClickListener: OnClickListener

    //Metodo donde crear el layout de la celda a ver
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.covid_view_holder,parent, false)
        return CovidViewHolder(view)
    }

    // Metodo que entrega información al viewHolder
    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val item = data[position]
        holder.bindView(item)
        //Se aplica la interfaz entregada en este caso por la MainActivity
        holder.itemView.setOnClickListener {
            onClickListener.onClickItem(item)
        }
    }
    // Metodo que define el largo de la lista
    override fun getItemCount(): Int {
        return data.size
    }
    // Metodo donde agrega un item al recyclerView
    fun addCase(case : CovidCase){
        data.add(case)
        this.notifyDataSetChanged()
    }

    // Clase interna con la definición del ViewHolder
    inner class CovidViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bindView(item: CovidCase){
            val dateTextView = view.findViewById<TextView>(R.id.date_text_view)
            val positiveTextView = view.findViewById<TextView>(R.id.positive_text_view)
            val negativeTextView = view.findViewById<TextView>(R.id.negative_text_view)
            dateTextView.text = item.date.toString()
            positiveTextView.text = item.positive.toString()
            negativeTextView.text = item.negative.toString()

        }
    }
}