package com.codepath.anuscorps23.onlycoin.helpers;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by anuscorps23 on 7/12/15.
 */
public class FileCache {
    private File cacheDir;


    public FileCache(Context context)
    {

        String state = Environment.getExternalStorageState();
        if(state .equals(Environment.MEDIA_MOUNTED))
        {
            cacheDir = new File(Environment.getExternalStorageDirectory(), "onlyCoinImages");
        }
        else
        {
            cacheDir = context.getCacheDir();
        }

        if(!cacheDir.mkdirs())
        {
            boolean b = cacheDir.mkdirs();
        }
    }

    public File getFile(String url)
    {
        String filename = String.valueOf(url.hashCode());

        File f = new File(cacheDir, filename);
        return f;
    }

    public void clear()
    {
        File[] files = cacheDir.listFiles();
        if(files == null)
        {
            return;
        }

        for(File f : files)
        {
            f.delete();
        }
    }
}

