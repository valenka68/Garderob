package com.example.valentinabulanova.garderob

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valentinabulanova.garderob.databinding.CardViewBinding

class ThingsAdapter(val listener: Listener): RecyclerView.Adapter<ThingsAdapter.ThingsHolder>() {
    val thingstList = ArrayList<Thing>()
    class ThingsHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CardViewBinding.bind(item)

        fun bind (thing: Thing, listener: Listener) = with(binding){
            ima.setImageResource(thing.imageID)
            tvTitle.text = thing.title
            itemView.setOnClickListener{
                listener.onClick(thing)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThingsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ThingsHolder(view)
    }

    override fun onBindViewHolder(holder: ThingsHolder, position: Int) {
        holder.bind(thingstList[position], listener)
    }

    override fun getItemCount(): Int {
        return thingstList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    public fun addThing (thing: Thing) {
        thingstList.add(thing)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(thing: Thing)
    }
}