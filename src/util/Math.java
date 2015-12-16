package util;

/**
 * Created by alagapm on 12/16/15.
 */
public class Math {

    public static double roundTo0_05(double value) {
        return java.lang.Math.round(value * 20.0) / 20.0;
    }
}
