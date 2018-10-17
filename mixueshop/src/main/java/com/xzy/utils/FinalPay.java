package com.xzy.utils;

import java.math.BigDecimal;

/**
 * Created by css on 2018/7/25.
 */
public class FinalPay {
    public static Double getDiscount(int level){
        Double discount=1.00;
        level=level+0;
        Integer x=level/100;
        switch (x){
            case 0: discount= 0.00; break;
            case 1: discount= 0.99; break;
            case 2: discount= 0.98; break;
            case 3: discount= 0.95; break;
            case 4: discount= 0.90; break;
            case 5: discount= 0.88; break;
            case 6: discount= 0.86; break;
            case 7: discount= 0.85; break;
            case 8: discount= 0.80; break;
            case 9: discount= 0.75; break;
            default:discount= 0.70;break;
        }
        return discount;
    }
}
