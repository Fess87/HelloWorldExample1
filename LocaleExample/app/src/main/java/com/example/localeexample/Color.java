package com.example.localeexample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import androidx.annotation.IntDef;

@IntDef({Color.Green, Color.Black, Color.Blue})
@Retention(RetentionPolicy.SOURCE)
public @interface Color {
    int Green = 0;
    int Black = 1;
    int Blue = 2;
}