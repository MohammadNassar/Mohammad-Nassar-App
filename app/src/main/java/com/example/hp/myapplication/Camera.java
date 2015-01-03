package com.example.hp.myapplication;

/** * Created by hp on 30/12/2014. */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener{

    ImageButton ib;
    Button b;
    ImageView iv;
    Intent intent;
    final int cameraData = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialise();
    }

    private void initialise() {

        iv = (ImageView) findViewById(R.id.ivReturnedPic);
        b = (Button) findViewById(R.id.bSetWallpaper);
        ib = (ImageButton) findViewById(R.id.ibTakePic);
        b.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bSetWallpaper :

                break;

            case R.id.ibTakePic :
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, cameraData);
                break;
        }
    }
}
