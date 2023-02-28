package com.example.simpleswip.adapter

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.daimajia.swipe.SwipeLayout.SwipeListener
import com.example.simpleswip.R
import com.example.simpleswip.utils.ClickInterface
import com.example.simpleswip.utils.Constants.Companion.selectedPosi
import kotlinx.android.synthetic.main.item_list.view.*
import java.net.CookieHandler

class TimesAdapter(var activity: Activity, var times: Array<String>,var clickInterface: ClickInterface) :
    RecyclerView.Adapter<TimesAdapter.ViewData>() {
    private var preswipes: SwipeLayout? = null

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  aTime = itemView.findViewById<TextView>(R.id.aTime)
        var itmDelete= itemView.findViewById<LinearLayout>(R.id.itmDelete)
        var swipes =  itemView.swipe
        var bgLinear = itemView.findViewById<LinearLayout>(R.id.bgLinear)


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

        if (selectedPosi == position.toString()){
            holder.bgLinear.setBackgroundColor(Color.DKGRAY)

        }else{
            holder.bgLinear.setBackgroundColor(activity.resources.getColor(R.color.white))

        }


        holder.swipes.isClickToClose = true
        holder.itmDelete.setOnClickListener {
            clickInterface.clickDelete(position)
        }

        holder.bgLinear.setOnClickListener {
            holder.bgLinear.setBackgroundColor(Color.DKGRAY)
            notifyDataSetChanged()
            selectedPosi = position.toString()
            Toast.makeText(activity,"Item click : "+position,Toast.LENGTH_SHORT).show()
        }
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