package com.okhttpclientdemo.ImageProcessing;

public class Picasso {


    public void setImage(){
        Picasso
                .with(this)
                .load("https://res.cloudinary.com/demo/video/upload/dog.png")
                .into(imageView);
    }
}
