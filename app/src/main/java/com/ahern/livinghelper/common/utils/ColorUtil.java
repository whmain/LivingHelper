package com.ahern.livinghelper.common.utils;

import java.util.Random;

/**
 * @auther: WangHao on 2017/9/8 11:42
 * @email：Ahern.h.wang@emore-smart.com
 */

public class ColorUtil {

    public static String randomColor(){
        Random random = new Random();
        int value = random.nextInt(3);
        String colorValue = "#FFFFFF";
        switch (value){
            case 0:
                colorValue = "#F26565";
            break;
            case 1:
                colorValue = "#65F284";
            break;
            case 2:
                colorValue = "#65C3F2";
            break;
            case 3:
                colorValue = "#A465F2";
            break;
        }

        return colorValue;
    }
}
