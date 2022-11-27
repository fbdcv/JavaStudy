package top.fbdcv.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtils {
    public static String getID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}

