package com.example.kcimagecarousel.Lib


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kcimagecarousel.R

class ImageAdopter (val data:ArrayList<Pair<Int,String>>,val animatation:Int?,val context: Context): RecyclerView.Adapter<ImageAdopter.v>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): v {
        val lay= LayoutInflater.from(parent.context).inflate(R.layout.sliderlayout,parent,false)
        return v(lay)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: v, position: Int) {
        val current=data[position]
        if (animatation!=null)
        {
            holder.cardimage.startAnimation(AnimationUtils.loadAnimation(context,animatation))
        }
        holder.image.setImageResource(current.first)

        holder.text.text=current.second.toString()
    }
    class v(v: View): RecyclerView.ViewHolder(v)
    {
        val image: ImageView =v.findViewById(R.id.imageview)
        val text: TextView =v.findViewById(R.id.title)
        val cardimage: CardView =v.findViewById(R.id.image)
    }
}