package com.example.kcimagecarousel.Lib


import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class Imagecrosole(val context:Context,val recyclerView: RecyclerView,val thumb:LinearLayout,val thumbcolor:Int,val backthumb:Int,val Delay:Long,val data:ArrayList<Pair<Int,String>>,val animataion:Int?) {
    private val scrollRunnable = Runnable { autoScroll() }
    private val handler = Handler()
    init {
        data.forEach {
            thumb.addView(createCardView())
        }
        recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter=ImageAdopter(data,animataion,context)
        scrollad()
        scrollbehavior()
    }
    fun scrollad() {
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                ImageSinfleton.currentPosition = layoutManager.findFirstVisibleItemPosition()
                // Do whatever you want with currentPosition
                Log.e("position", "${ImageSinfleton.currentPosition}")
                updateCardViewBackgrounds(thumb)
            }


        })
    }

    fun updateCardViewBackgrounds(thumb: LinearLayout) {
        thumb.children.forEachIndexed { index, view ->
            if (view is CardView) {
                if (index == ImageSinfleton.currentPosition) {
                    view.setCardBackgroundColor(ContextCompat.getColor(context, thumbcolor))
                    changeCardViewSize(30, 30, view)


                } else {

                    view.setCardBackgroundColor(ContextCompat.getColor(context, backthumb))
                    changeCardViewSize(20, 20, view)
                    //    kc.AnimationStater(view,kc.fadeout)
                }
            }
        }
    }
    fun changeCardViewSize(newWidth: Int, newHeight: Int, myCardView: View) {
        // Get the current layout parameters of the CardView
        val layoutParams: ViewGroup.LayoutParams = myCardView.layoutParams

        // Update width and height
        layoutParams.width = newWidth
        layoutParams.height = newHeight

        // Apply the updated layout parameters to the CardView
        myCardView.layoutParams = layoutParams
    }
    fun autoScroll() {
        // Scroll to the next position
        val nextPosition = (recyclerView.layoutManager as LinearLayoutManager)
            .findFirstVisibleItemPosition() + 1

        recyclerView.smoothScrollToPosition(nextPosition)

        // Schedule the next scroll after 1 second
        handler.postDelayed(scrollRunnable, Delay)
    }
    fun scrollbehavior()
    {
        handler.postDelayed(scrollRunnable, 3000)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                // Check if the RecyclerView has reached the end
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                    // Scroll back to the beginning
                    recyclerView.scrollToPosition(0)
                }
            }
        })
    }
    fun createCardView(): CardView {
        val cardView = CardView(context)

        // Set card corner radius
        cardView.radius = 20f // Set your desired radius here

        // Set card background color
        cardView.setCardBackgroundColor(ContextCompat.getColor(context, thumbcolor))

        // Set layout parameters for the CardView
        val layoutParams = LinearLayout.LayoutParams(
            20, // Set your desired width in pixels
            20 // Set your desired height in pixels
        )

        // Set margins for the CardView
        layoutParams.setMargins(
            10, // Set your desired left margin in pixels
            10, // Set your desired top margin in pixels
            10, // Set your desired right margin in pixels
            10 // Set your desired bottom margin in pixels
        )

        // Apply layout parameters to the CardView
        cardView.layoutParams = layoutParams
        return cardView
    }
}