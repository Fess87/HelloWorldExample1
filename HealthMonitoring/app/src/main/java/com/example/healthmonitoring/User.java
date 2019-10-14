package com.example.healthmonitoring;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class User {
        private String FIO;
        private int age;

    public User(String FIO, int age) {
        this.FIO = FIO;
        this.age = age;
    }

    public String getFIO() {
        return FIO;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return FIO.equals(user.FIO);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(FIO);
    }
}
