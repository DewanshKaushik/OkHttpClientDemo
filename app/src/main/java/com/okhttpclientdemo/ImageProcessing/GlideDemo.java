package com.okhttpclientdemo.ImageProcessing;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideDemo {


    public void setGlide(Context context, ImageView imageView){
        Glide.with(context)
                .load("https://res.cloudinary.com/demo/video/upload/dog.png")
                .into(imageView);





    }


}
