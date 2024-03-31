package com.example.kcimagecarousel.Lib


import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kcimagecarousel.R


class Image_Carousel  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var Thumb:LinearLayout
    private var ImageCarosel:RecyclerView
    init {
        val inflatedView= LayoutInflater.from(context).inflate(R.layout.imagecrosole, this, true)



// Now recyclerView and linearLayout variables should hold references to RecyclerView and LinearLayout, respectively
// Now add another LinearLayout with a RecyclerView and another LinearLayout
        val innerLinearLayout = LinearLayout(context)
        innerLinearLayout.orientation=LinearLayout.VERTICAL


        ImageCarosel = RecyclerView(context)

// Set RecyclerView properties if needed
        innerLinearLayout.addView(ImageCarosel)

// Add another LinearLayout to the inner LinearLayout
        Thumb = LinearLayout(context)

        Thumb.orientation=LinearLayout.HORIZONTAL
        Thumb.gravity=Gravity.CENTER_HORIZONTAL
        // Set innerLinearLayout2 properties if needed
        innerLinearLayout.addView(Thumb)

// Add the inner LinearLayout to the main LinearLayout
        if (inflatedView is ViewGroup)
            inflatedView.addView(innerLinearLayout)




    }



    fun setImage_Carousel(  context:Context,thumbcolor:Int, backthumb:Int, Delay:Long, data:ArrayList<Pair<Int,String>>,iscustomAnimation:Boolean,animatation:Int?)
    {


        if (iscustomAnimation)
        {
            Imagecrosole(context,ImageCarosel,Thumb,thumbcolor,backthumb,Delay, data,animatation)

        }else{
            Imagecrosole(context,ImageCarosel,Thumb,thumbcolor,backthumb,Delay, data,null)

        }

    }

}