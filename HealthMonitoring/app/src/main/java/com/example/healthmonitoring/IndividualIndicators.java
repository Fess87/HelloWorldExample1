package com.example.healthmonitoring;

import android.icu.util.LocaleData;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class IndividualIndicators {

    private int highPressure;
    private int lowPressure;
    private int pulse;
    private boolean tachycardia;
    private LocalDateTime time;

    public IndividualIndicators(int highPressure, int lowPressure, int pulse, boolean tachycardia) {
        this.highPressure = highPressure;
        this.lowPressure = lowPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.time = LocalDateTime.now();
    }

    public int getHighPressure() {
        return highPressure;
    }

    public int getLowPressure() {
        return lowPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }

    public LocalDateTime getTime() {
        return time;
    }


}
