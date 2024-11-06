package com.example.uilover.view.binding

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.example.uilover.BR

@BindingAdapter("imageResource")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

class HomeBinder : BaseObservable() {


    @get:Bindable
    var username: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.username)
        }

    @get:Bindable
    var image: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.image)
        }

}