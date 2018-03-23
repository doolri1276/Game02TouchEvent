package com.snownaul.game02touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));

        //제목줄 제거(숨기기)
        getSupportActionBar().hide();

        //상태표시줄 제거(전체화면모드)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
}
