package com.example.ymiwa.doubutunotsume.com.example.ymiwa.doubutunotsume.common;

/**
 * ボードのコマをタップした情報を管理する
 */
public class TouchData {
    public int count;
    public int touchObj[] = new int[2];
    public PlayBoard playBoard;

    // コンストラクタ
    public TouchData(PlayBoard playBoard) {
        this.playBoard = playBoard;
        clear();
    }

    // 対象と移動先を登録する
    public int tap(int no) {
        if (this.count >= 2) {
            return 1;
        }
        // 登録と判定
        this.touchObj[this.count] = no;
        if (!check()) {
            this.count = 0;
            this.touchObj[0] = -1;
            this.touchObj[1] = -1;
            return -1;
        }else{
            this.count += 1;
            return 0;
        }
    }

    // 初期化
    public void clear() {
        this.count = 0;
        this.touchObj[0] = -1;
        this.touchObj[1] = -1;
    }

    // 移動元
    public int from() {
        return this.touchObj[0];
    }

    // 移動先
    public  int to() {
        return this.touchObj[1];
    }

    // 移動を許可するか？
    public boolean check() {
        if (this.touchObj[0] == this.touchObj[1]) {
            // タッチされたデータが同じものである場合は false を返す
            return  false;
        }
        switch (this.count) {
        case 0:
            if (!this.playBoard.isSelectOK_From(this.touchObj[0])) {
                // 選択範囲外の場合
                return false;
            }
            break;
        case 1:
            if (!this.playBoard.isSelectOK_To(this.touchObj[1])) {
                // 選択範囲外の場合
                return false;
            }
            break;
        }
        return true;
    }
}
