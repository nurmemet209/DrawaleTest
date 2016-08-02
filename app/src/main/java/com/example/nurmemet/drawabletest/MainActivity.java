package com.example.nurmemet.drawabletest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.cn.ra.CircleImageDrawable;
import com.cn.ra.RoundRectDrawable;

public class MainActivity extends AppCompatActivity {
    private ImageView shaderImpl;
    private ImageView circleShaderImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shaderImpl = (ImageView) findViewById(R.id.round_rect_shader_impl);
        circleShaderImpl = (ImageView) findViewById(R.id.circle_shader_impl);
        Bitmap shaderBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.shader_impl);
        RoundRectDrawable roundRectDrawable = new RoundRectDrawable(shaderBmp);
        shaderImpl.setImageDrawable(roundRectDrawable);
        CircleImageDrawable circleImageDrawable = new CircleImageDrawable(shaderBmp);
        circleShaderImpl.setImageDrawable(circleImageDrawable);
    }


}
