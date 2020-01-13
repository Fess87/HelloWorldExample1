package com.example.notessavelyev;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface PinRepository {

    void setPin(@NonNull String pin);

    @Nullable
    String getPin();

    boolean isPinCodeSet();
}
