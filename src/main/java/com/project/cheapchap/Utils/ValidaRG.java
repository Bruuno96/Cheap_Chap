package com.project.cheapchap.Utils;

import java.util.ArrayList;
import java.util.List;

public class ValidaRG {

    private static final String RG_PATTERN = "\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d-\\d";

    public static boolean isRG(String rg) {
        // rg = "ab.cde.fgh-i"
        // testar formato (opcional)
        if (! rg.matches(RG_PATTERN)) {
            System.err.println(rg + " formato");
            return false;
        }

        int a = rg.charAt(0) - '0';
        int b = rg.charAt(1) - '0';
        //  . = rg.charAt(2)
        int c = rg.charAt(3) - '0';
        int d = rg.charAt(4) - '0';
        int e = rg.charAt(5) - '0';
        //  . = rg.charAt(6)
        int f = rg.charAt(7) - '0';
        int g = rg.charAt(8) - '0';
        int h = rg.charAt(9) - '0';
        //  - = rg.charAt(10)
        int i = rg.charAt(11) - '0';

        int result = 2*a + 3*b + 4*c + 5*d + 6*e + 7*f + 8*g + 9*h + 100*i;
        return (result % 11) == 0;
    }
}
