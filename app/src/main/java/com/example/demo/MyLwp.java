package com.example.demo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.service.wallpaper.WallpaperService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;

public class MyLwp extends WallpaperService {
    public Engine onCreateEngine(){
        return new MyEngine();
    }

    class MyEngine extends Engine{
        //获取SurfaceHolder时调用
        @Override
        public SurfaceHolder getSurfaceHolder() {
            return super.getSurfaceHolder();
        }

        public void onDestroy(){
            super.onDestroy();
        }

        public void onSurfaceChanged(SurfaceHolder holder ,int format ,int width ,int height){
            super.onSurfaceChanged(holder,format,width,height);
        }
        public  void onSurfaceCreated(SurfaceHolder holder){
            super.onSurfaceCreated(holder);
            Canvas canvas = holder.lockCanvas();
            canvas.drawColor(Color.RED);
            holder.unlockCanvasAndPost(canvas);
        }
        public void onSurfaceDestroyed(SurfaceHolder holder){
            super.onSurfaceDestroyed(holder);
        }
    }
}
