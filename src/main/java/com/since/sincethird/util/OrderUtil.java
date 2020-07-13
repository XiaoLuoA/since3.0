package com.since.sincethird.util;

import java.util.Random;

public class OrderUtil {
    public static final char[] random_str = {
        '0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l',
            'm','n','o','p','q','r','s','t','u','v','w','x','y','z'
    };

    public static String genOrderNo(){
        Random random = new Random();
        int x = random.nextInt(36);
        int y = random.nextInt(36);
        int z = random.nextInt(36);
        return ""+System.currentTimeMillis()+random_str[x]
                +random_str[y]+random_str[z];
    }
}
