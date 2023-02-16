package com.example.simpleswip.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.daimajia.swipe.SwipeLayout.SwipeListener
import com.example.simpleswip.R
import kotlinx.android.synthetic.main.item_list.view.*

class TimesAdapter(var activity: Activity, var times: Array<String>) :
    RecyclerView.Adapter<TimesAdapter.ViewData>() {
    private var preswipes: SwipeLayout? = null

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  aTime = itemView.findViewById<TextView>(R.id.aTime)
        var swipes =  itemView.swipe


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_list, parent, false)
        return ViewData(view)
    }

    override fun getItemCount(): Int {
        return times.size
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.aTime.text = times[position]


        holder.swipes.isClickToClose = true
        holder.swipes.addSwipeListener(object : SwipeListener {
            override fun onStartOpen(layout: SwipeLayout) {
                if (preswipes == null) {
                    preswipes = layout
                } else {
                    preswipes!!.close(true)
                    preswipes = layout
                }
            }

            override fun onOpen(layout: SwipeLayout) { /*Toast.makeText(activity,"onOpen",Toast.LENGTH_SHORT).show()*/ }
            override fun onStartClose(layout: SwipeLayout) {  /*Toast.makeText(activity,"onStartClose",Toast.LENGTH_SHORT).show()*/ }
            override fun onClose(layout: SwipeLayout) {/*Toast.makeText(activity,"onClose",Toast.LENGTH_SHORT).show()*/}
            override fun onUpdate(layout: SwipeLayout, leftOffset: Int, topOffset: Int) {/*Toast.makeText(activity,"onUpdate",Toast.LENGTH_SHORT).show()*/}
            override fun onHandRelease(layout: SwipeLayout, xvel: Float, yvel: Float) {/*Toast.makeText(activity,"onHandRelease",Toast.LENGTH_SHORT).show()*/}
        })

    }
}