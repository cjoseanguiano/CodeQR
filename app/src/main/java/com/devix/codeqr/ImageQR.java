package com.devix.codeqr;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.devix.codeqr_chat_bsd.R;

public class ImageQR extends AppCompatActivity {

    private ImageView imageView;
//TODO: SIN FUNCIONAMIENTO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_qr);
        imageView = (ImageView) this.findViewById(R.id.imgCodeQR);
        Bitmap bitmap = getIntent().getParcelableExtra("code");
        imageView.setImageBitmap(bitmap);
    }
}
