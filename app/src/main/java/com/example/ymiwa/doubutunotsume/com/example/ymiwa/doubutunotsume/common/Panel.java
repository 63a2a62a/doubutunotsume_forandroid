package com.example.ymiwa.doubutunotsume.com.example.ymiwa.doubutunotsume.common;

/**
 * Created by ymiwa on 16/02/11.
 */
public class Panel {
    private int A1 = 0, B1 =  1, C1 =  2;
    private int A2 = 3, B2 =  4, C2 =  5;
    private int A3 = 6, B3 =  7, C3 =  8;
    private int A4 = 9, B4 = 10, C4 = 11;

    // 番号を位置の文字列に当てはめた値を返す
    public String getPanelText(int num) {
        String name;
        switch (num) {
            case  0:  name = "A1";
            case  1:  name = "B1";
            case  2:  name = "C1";
            case  3:  name = "A2";
            case  4:  name = "B2";
            case  5:  name = "C2";
            case  6:  name = "A3";
            case  7:  name = "B3";
            case  8:  name = "C3";
            case  9:  name = "A4";
            case 10:  name = "B4";
            case 11:  name = "C4";
            default:  name = null;
        }
        return name;
    }

    // 番号を位置のどうぶつに当てはめた値を返す
    public String getTypeText(int num) {
        String name;
        switch (num) {
            case  1:  name = "ひよこ";
            case  2:  name = "ぞう";
            case  3:  name = "きりん";
            case  4:  name = "らいおん";
            case  5:  name = "にわとり";
            case  6:  name = "ひよこ";
            case  7:  name = "ぞう";
            case  8:  name = "きりん";
            case  9:  name = "らいおん";
            case 10:  name = "にわとり";
            default:  name = null;
        }
        return name;
    }
}
