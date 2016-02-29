package com.example.ymiwa.doubutunotsume.com.example.ymiwa.doubutunotsume.common;

/**
 * Created by ymiwa on 16/02/11.
 */
public class PlayBoard {
    // プレイヤー情報
    private int turn = 1;       // 0:Player1, 1:Player2
    // ボード情報
    private int panelData[];

    // コンストラクタ
    public PlayBoard() {
        // 初期化したいものがあればここで定義する
        this.panelData = new int[]
                      { 8,9,7,            // Main Board
                        0,6,0,
                        0,1,0,
                        2,4,3,
                        0,0,0,0,0,0,      // Player1(上)
                        0,0,0,0,0,0 };    // Player2(下)

        this.panelData = panelData;
    }

    // 選択を許可するか(移動元)
    public boolean isSelectOK_From(int idx) {
        // 移動元は空のマスの選択不可
        if (this.panelData[idx] == 0) {
            return false;
        }
        // 移動元は相手のコマの選択不可
        if (this.turn == 0) {
            // Player1=6以上
            if (this.panelData[idx] >= 6) {
                return true;
            }
        }else{
            // Player2=5以下
            if (this.panelData[idx] <= 5) {
                return true;
            }
        }
        return false;
    }

    // 選択を許可するか(移動先)
    public boolean isSelectOK_To(int idx) {
        // 移動先が空のマスの場合はOK
        if (this.panelData[idx] == 0) {
            return true;
        }
        // 移動先は自分のコマの選択不可
        if (this.turn == 0) {
            // Player1=6以上なので、相手は5以下
            if (this.panelData[idx] <= 5) {
                return true;
            }
        }else{
            // Player2=5以下なので、相手は6以上
            if (this.panelData[idx] >= 6) {
                return true;
            }
        }
        return false;
    }

    // 移動
    public boolean move(int fromIdx, int toIdx) {
        int wk_fromPiece = this.panelData[fromIdx];
        int wk_toPiece = this.panelData[toIdx];

        this.panelData[fromIdx] = 0;
        this.panelData[toIdx] = wk_fromPiece;

        // 相手陣地に入ったらひよこをにわとりに変える
        if (0<=toIdx && toIdx<=2) {
            this.panelData[toIdx] = (wk_fromPiece==1) ? 5 : wk_fromPiece;
        }else
        if (9<=toIdx && toIdx<=11) {
            this.panelData[toIdx] = (wk_fromPiece==6) ? 10 : wk_fromPiece;
        }

        // 相手のコマを取った時に自分の場に置く処理
        if (wk_toPiece != 0) {
            if (turn == 0) {
                // Player1の持ちコマ
                for (int nn=12; nn<=17; nn++) {
                    if (this.panelData[nn] == 0) {
                        this.panelData[nn] = wk_toPiece + 5;
                        if (this.panelData[nn]==10) {
                            this.panelData[nn] = 6;
                        }
                        break;
                    }
                }
            }else{
                // Player2の持ちコマ
                for (int nn=18; nn<=23; nn++) {
                    if (this.panelData[nn] == 0) {
                        this.panelData[nn] = wk_toPiece - 5;
                        if (this.panelData[nn]==5) {
                            this.panelData[nn] = 1;
                        }
                        break;
                    }
                }
            }
        }
        return true;
    }

    // 盤のデータ
    public int[] getPanelData() {
        return this.panelData;
    }

    // アクティブなプレイヤーを返す
    public int getActiveplayer() {
        return turn;
    }

    // プレイヤーのターンチェンジ
    public void turnChange() {
        turnChangeN((this.turn == 0) ? 1 : 0);
    }

    // プレイヤーのターンチェンジ（指定）
    public void turnChangeN(int num) {
        this.turn = num;
    }

    // リセット
    public void reset() {
        this.panelData = new int[]
                    { 8,9,7,            // Main Board
                      0,6,0,
                      0,1,0,
                      2,4,3,
                      0,0,0,0,0,0,      // Player1(上)
                      0,0,0,0,0,0 };    // Player2(下)

        this.panelData = panelData;
        this.turn = 1;
    }

}
