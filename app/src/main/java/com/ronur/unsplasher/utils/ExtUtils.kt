package com.ronur.unsplasher.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ronur.unsplasher.base.BaseAdapter
import java.util.*

object ExtUtils {
    @JvmStatic
    @BindingAdapter("adapter")
    fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
//        this.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        this.setHasFixedSize(true)
        this.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("updateList")
    fun RecyclerView.updateList(list: List<Nothing>?) {
        if(list != null){
            (this.adapter as BaseAdapter<*, *>).updateList(list)
        }
    }

    @JvmStatic
    fun isNight(): Boolean {
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return (currentHour <= 7 || currentHour >= 18)
    }

    @JvmStatic
    @BindingAdapter(
        "glideSrc",
        "glideRoundedCorner",
        "glideCircularCrop",
        requireAll = false
    )
    fun ImageView.bindGlideSrc(
        url: String?,
        roundedCorner: Boolean = false,
        circularCrop: Boolean = false
    ) {
        if(url == null) return

        createGlideRequest(
            context,
            url,
            roundedCorner,
            circularCrop
        ).into(this)
    }

    @JvmStatic
    private fun createGlideRequest(
        context: Context,
        url: String,
        roundedCorner: Boolean,
        circularCrop: Boolean
    ): RequestBuilder<Drawable> {
        val req = Glide.with(context).load(url)
        if (roundedCorner) req.apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
        if (circularCrop) req.circleCrop()
        return req
    }
}