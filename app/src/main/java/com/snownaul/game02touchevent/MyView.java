package com.snownaul.game02touchevent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by alfo6-11 on 2018-03-23.
 */

public class MyView extends View {

    int width, height;//화면의 가로세로 사이즈

    Bitmap img;
    int x,y;
    int w,h;

    int dx,dy;//변화량

    public MyView(Context context) {
        super(context);

        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        width=display.getWidth();
        height=display.getHeight();

        //rabbit_1.png-->Bitmap객체
        Resources res=context.getResources();
        img= BitmapFactory.decodeResource(res,R.drawable.rabbit_1);
        img=Bitmap.createScaledBitmap(img,300,330,true);//마지막값은 확대/축소시 부드럽게 할것인가?

        w=img.getWidth()/2;
        h=img.getHeight()/2;

        //이미지의 최초 위치 좌표
        x=width/2;
        y=height/2;

        dx=0;
        dy=0;

        //행운의 편지 발송
        handler.sendEmptyMessageDelayed(0,10);

    }

    //생성자가 끝나면 딱 한번 호출되고 화면에 보여지는 작업을 수행하는 메소드드
    @Override
    protected void onDraw(Canvas canvas) {

       //캐릭터 이동(좌표 변경)
       x+=dx;
       y+=dy;

       //왼쪽벽
       if(x<=w){
           dx=-dx;
           x=w;
       }

       //오른쪽
        if(x>=width-w){
           dx=-dx;
           x=width-w;
        }

       //위쪽
        if(y<=h){
            dy=-dy;
            y=h;
        }

        //아래쪽
        if(y>=height-h){
            dy=-dy;
            y=height-h;
        }

       canvas.drawBitmap(img,x-w,y-h,null);

    }

    Handler handler= new Handler(){

        @Override
        public void handleMessage(Message msg) {

            invalidate();//화면갱신(onDraw가 다시 호출)
            sendEmptyMessageDelayed(0,10);

        }
    };


}