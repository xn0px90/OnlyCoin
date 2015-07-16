package com.codepath.anuscorps23.onlycoin.helpers;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by anuscorps23 on 7/12/15.
 */
public class Utils {

    public static void copyStream(InputStream is, OutputStream os)
    {
        final int buffer_size = 1024;

        try {
            byte[] bytes = new byte[buffer_size];
            while(true)
            {
                int count = is.read(bytes, 0, buffer_size);
                if(count == -1)
                {
                    break;
                }
                os.write(bytes, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
