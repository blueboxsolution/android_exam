package com.bbx.androidexam.common;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by macbookair on 27/09/2017.
 */

public final class InternalStorage{

    public InternalStorage() {}

    public static void writeObject(Context context, String key, String list) throws IOException {

        File file = new File(context.getCacheDir(), key);

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(list);
        bw.close();

    }

    public static String readObject(Context context, String key) throws IOException,
            ClassNotFoundException {
        BufferedReader input = null;
        File file = null;
        try {
            file = new File(context.getCacheDir(), key);

            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = input.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isFileExist(Context context, String key){
        File f = new File(context.getCacheDir(), key);

        if (f.isFile() && f.canRead()) {
            try {
                FileInputStream in = new FileInputStream(f);
                try {
                   return true;
                } finally {
                    in.close();
                }
            } catch (IOException ex) {
                // Appropriate error handling here.
            }
        }
        return false;
    }
}