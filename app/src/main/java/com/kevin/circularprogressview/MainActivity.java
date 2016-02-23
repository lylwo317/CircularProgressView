package com.kevin.circularprogressview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.kevin.circularprogressview.drawable.CircularProgressDrawable;

public class MainActivity extends AppCompatActivity {

    private ImageView mIvCircular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIvCircular = (ImageView) findViewById(R.id.iv_circular);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable.Build(getApplicationContext(),R.style.Material_Drawable_CircularProgress).build();
        mIvCircular.setBackgroundDrawable(circularProgressDrawable);
        circularProgressDrawable.start();
    }
}
