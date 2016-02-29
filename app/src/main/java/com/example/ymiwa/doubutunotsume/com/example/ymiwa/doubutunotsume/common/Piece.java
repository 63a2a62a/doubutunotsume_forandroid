package com.example.ymiwa.doubutunotsume.com.example.ymiwa.doubutunotsume.common;

/**
 * Created by ymiwa on 16/02/11.
 */
public class Piece {
    int idx;    // 盤上の場所
    int type;   // 種別

    public void init(int idx, int type) {
        this.idx = idx;
        this.type = type;
    }
}
