package com.example.imagecorsol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kcimagecarousel.Lib.Image_Carousel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Data=ArrayList<Pair<Int,String>>()
        Data.add(Pair(R.drawable.ic_launcher_foreground,""))
        Data.add(Pair(R.drawable.ic_launcher_foreground,""))
        Data.add(Pair(R.drawable.ic_launcher_foreground,""))
        Data.add(Pair(R.drawable.ic_launcher_foreground,""))
        Data.add(Pair(R.drawable.ic_launcher_foreground,""))
        Data.add(Pair(R.drawable.ic_launcher_foreground,""))

       val v: Image_Carousel=findViewById(R.id.ima)

        v.setImage_Carousel(this,R.color.gray,R.color.black,5000,Data,true, com.example.animation.R.anim.zero_to_orignal)
    }
}