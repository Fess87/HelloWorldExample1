package com.example.emaillistexample;


import android.graphics.drawable.Drawable;
import android.os.Build;


import androidx.annotation.RequiresApi;

import java.time.LocalTime;

public class ItemMail {

    final String senderName;
    final String headEmail;
    final String textEmail;
    final LocalTime time;
    final Drawable image;
    private boolean box;



    @RequiresApi(api = Build.VERSION_CODES.O)
    ItemMail(String senderName, String headEmail, String textEmail, Drawable image, boolean box) {
        this.senderName = senderName;
        this.headEmail = headEmail;
        this.textEmail = textEmail;
        this.image = image;
        this.box = box;
        this.time = LocalTime.now();
    }

    public String getSenderName() {
        return senderName;
    }

    public String getHeadEmail() {
        return headEmail;
    }

    public String getTextEmail() {
        return textEmail;
    }

    public LocalTime getTime() {
        return time;
    }

    public Drawable getImage() {
        return image;
    }

    public boolean isBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }
}
