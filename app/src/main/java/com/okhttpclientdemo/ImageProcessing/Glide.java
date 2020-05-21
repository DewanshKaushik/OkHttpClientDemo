package com.okhttpclientdemo.ImageProcessing;

public class Glide {


    public void setGlide(){
        GlideApp
                .with(this)
                .load("https://res.cloudinary.com/demo/video/upload/dog.png")
                .into(imageView);





    }


}
