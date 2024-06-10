package org.swu.pokedex0528.extension

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import org.swu.pokedex0528.R

var factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

@BindingAdapter("imageUrl")
fun setImage(image: AppCompatImageView, url: String?) {

    Glide.with(image.context)
        .load(url?:"")
        .error(R.mipmap.ic_launcher)
        .transition(withCrossFade(factory))
        .into(image)

}
