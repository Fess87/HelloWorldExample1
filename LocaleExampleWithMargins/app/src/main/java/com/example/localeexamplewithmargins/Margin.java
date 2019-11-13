package com.example.localeexamplewithmargins;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import androidx.annotation.IntDef;

@IntDef({Margin.Small, Margin.Medium, Margin.Large})
@Retention(RetentionPolicy.SOURCE)
public @interface Margin {
    int Small = 0;
    int Medium = 1;
    int Large = 2;
}