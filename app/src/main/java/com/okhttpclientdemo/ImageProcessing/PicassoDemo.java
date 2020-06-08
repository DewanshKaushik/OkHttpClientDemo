package com.okhttpclientdemo.ImageProcessing;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoDemo {


    public void setImage(Context context, ImageView imageView){
        Picasso.with(context)
                .load("https://res.cloudinary.com/demo/video/upload/dog.png")
                .into(imageView);
    }
}
