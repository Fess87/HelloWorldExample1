package com.example.example511;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public static File getProductsFile(Context context, boolean newFile) throws IOException {
        File file = new File(context.getExternalFilesDir(null), "items.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else if (newFile) {
            file.delete();
            file.createNewFile();
        }
        return file;
    }

    public static void updateItemsFile(Context context, ArrayList<String> arrayList) throws IOException {
        FileWriter writer = new FileWriter(getProductsFile(context, true));
        for (String item : arrayList) {
            writer.write(item+"\n");
        }
        writer.flush();
        writer.close();
    }
}
