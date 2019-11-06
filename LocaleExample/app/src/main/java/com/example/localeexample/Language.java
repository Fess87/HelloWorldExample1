package com.example.localeexample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@IntDef({Language.Russian, Language.English, Language.Deutsch})
@Retention(RetentionPolicy.SOURCE)
public @interface Language {
    int Russian = 0;
    int English = 1;
    int Deutsch = 2;
}