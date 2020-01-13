package com.example.notessavelyev;

import android.content.Context;

import com.example.notessavelyev.HashUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import androidx.annotation.NonNull;

public class HashedPinRepository implements PinRepository {

    private final Context context;
    private final static String FILE_NAME = "pin.txt";

    public HashedPinRepository(final Context context) {
        this.context = context;
    }

    @Override
    public void setPin(@NonNull final String pin) {
        final File file = new File(context.getFilesDir(), FILE_NAME);
        if (!file.exists()) {
            try {
                final FileOutputStream outputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                final String hashPin = HashUtils.md5Custom(pin);
                outputStream.write(hashPin.getBytes());
                outputStream.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getPin() {
        try {
            final InputStreamReader inputStreamReader = new InputStreamReader(context.openFileInput(FILE_NAME));
            final BufferedReader reader = new BufferedReader(inputStreamReader);
            return reader.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean isPinCodeSet() {
        final File file = new File(context.getFilesDir(), FILE_NAME);
        return file.exists();
    }
}
