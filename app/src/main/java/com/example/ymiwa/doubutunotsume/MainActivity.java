package com.example.ymiwa.doubutunotsume;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.ymiwa.doubutunotsume.com.example.ymiwa.doubutunotsume.common.PlayBoard;
import com.example.ymiwa.doubutunotsume.com.example.ymiwa.doubutunotsume.common.TouchData;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    private TouchData touchData;
    private ImageButton btnList[];
    private PlayBoard playBoard;

    // 初期化処理
    private void doInit() {
        // ボードのオブジェクト
        this.playBoard = new PlayBoard();

        // ボタンを押した情報を保持するクラスを定義
        this.touchData = new TouchData(this.playBoard);

        // 扱いやすいようにボタンのオブジェクトを配列に格納
        btnList = new ImageButton[]{
                (ImageButton)findViewById(R.id.piece1),
                (ImageButton)findViewById(R.id.piece2),
                (ImageButton)findViewById(R.id.piece3),
                (ImageButton)findViewById(R.id.piece4),
                (ImageButton)findViewById(R.id.piece5),
                (ImageButton)findViewById(R.id.piece6),
                (ImageButton)findViewById(R.id.piece7),
                (ImageButton)findViewById(R.id.piece8),
                (ImageButton)findViewById(R.id.piece9),
                (ImageButton)findViewById(R.id.piece10),
                (ImageButton)findViewById(R.id.piece11),
                (ImageButton)findViewById(R.id.piece12),
                (ImageButton)findViewById(R.id.piece13),
                (ImageButton)findViewById(R.id.piece14),
                (ImageButton)findViewById(R.id.piece15),
                (ImageButton)findViewById(R.id.piece16),
                (ImageButton)findViewById(R.id.piece17),
                (ImageButton)findViewById(R.id.piece18),
                (ImageButton)findViewById(R.id.piece19),
                (ImageButton)findViewById(R.id.piece20),
                (ImageButton)findViewById(R.id.piece21),
                (ImageButton)findViewById(R.id.piece22),
                (ImageButton)findViewById(R.id.piece23),
                (ImageButton)findViewById(R.id.piece24),
        };

        // ボタンをタップした時のイベントを登録
        int tag = 0;
        for (int n=0; n<=23; n++) {
            btnList[n].setTag(new Integer(tag++));
            btnList[n].setOnClickListener(this);
            btnList[n].setImageResource(R.drawable.blank);
        }

        // 描画
        drawPanel();
    }

    // 各コマをタッチした際のイベント
    @Override
    public void onClick(View v) {
        ImageButton sender = (ImageButton)v;
        int tag = ((Integer)sender.getTag()).intValue();
        // 問題を解くモード
        if (this.touchData.tap(tag) == 0) {
            // タップされたのでボタンの色を変更
            sender.setBackgroundColor((this.playBoard.getActiveplayer() == 0) ? Color.YELLOW : Color.CYAN);
            if (this.touchData.count >= 2) {
                // コマの移動, ターンチェンジ
                if (playBoard.move(this.touchData.from(), this.touchData.to())) {
                    // 描画
                    drawPanel();
                    this.playBoard.turnChange();
                }
                this.touchData.clear();
            }
        }else{
            // エラー判定の場合は再描画してクリアする
            drawPanel();
        }
    }

    // パネルの再描画
    public void drawPanel() {
        int panelData[] = this.playBoard.getPanelData();
        for (int n=0; n<panelData.length; n++) {
            if (1<=panelData[n] && panelData[n]<=10) {
                // コマあり
                Log.d(TAG, "btn = " + panelData[n]);
                this.btnList[n].setImageResource(getFileName(panelData[n]));
            }else{
                // コマなし（ブランク）
                this.btnList[n ].setImageResource(R.drawable.blank);
            }
            // 背景色を透明に戻す
            this.btnList[n].setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doInit();
    }

    private int getFileName(int num) {
        int name;
        switch (num) {
            case  1:  name = R.drawable.piece1;  break;
            case  2:  name = R.drawable.piece2;  break;
            case  3:  name = R.drawable.piece3;  break;
            case  4:  name = R.drawable.piece4;  break;
            case  5:  name = R.drawable.piece5;  break;
            case  6:  name = R.drawable.piece6;  break;
            case  7:  name = R.drawable.piece7;  break;
            case  8:  name = R.drawable.piece8;  break;
            case  9:  name = R.drawable.piece9;  break;
            case 10:  name = R.drawable.piece10; break;
            default:  name = R.drawable.blank;   break;
        }
        return name;
    }
}
