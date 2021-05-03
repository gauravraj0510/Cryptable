package com.example.cryptable;

public class EncodeText {

    public static String encText(String s){
        String initializer = "11111111";
        int ct = 0;
        int a[] = new int[11111111];

        for (int i=0; i<s.length(); i++){
            a[i] = (int)s.charAt(i);
            ct++;
        }
        String res = "";
        int bin[] = new int[111];
        int idx = 8;
        for (int i=0; i<ct; i++) {
            int temp = a[i];
            for (int j = 0; j < ct; j++)
                bin[j] = 0;
            idx = 8;
            while (temp > 0) {
                bin[idx++] = temp % 2;
                temp = temp / 2;
            }

            String dig = "";
            String temps;
            for (int j = 0; j < 7; j++) {
                temps = Integer.toString(bin[j]);
                dig = dig.concat(temps);
            }

            String rev = "";
            for (int j = dig.length() - 1; j >= 0; j--) {
                char ca = dig.charAt(j);
                rev = rev.concat(String.valueOf(ca));
            }
            res = res.concat(rev);
        }
        res = initializer.concat(res);
        return res;
    }
}
