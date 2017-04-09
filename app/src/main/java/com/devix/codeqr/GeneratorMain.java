package com.devix.codeqr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.devix.codeqr_chat_bsd.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class GeneratorMain extends AppCompatActivity {

    private Button btnGenerate;
    private EditText editText;
    private ImageView imageView;
    boolean activateButton = false;
    @ColorInt
    public static final int BLUE = 0xFF0000FF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.TitleGenerator);
        }
        final Context context = this;
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        editText = (EditText) findViewById(R.id.edtGenerator);
        imageView = (ImageView) findViewById(R.id.imgCodeQR);
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoQR = editText.getText().toString();
                if (!(textoQR.length() == 0)) {
                    btnGenerate.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                    editText.setText("");
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try {
                        BitMatrix bitMatrix = multiFormatWriter.encode(textoQR, BarcodeFormat.QR_CODE, 500, 500);
                        int width = bitMatrix.getWidth();
                        int height = bitMatrix.getHeight();
//
//                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                        for (int x = 0; x < width; x++) {
                            for (int y = 0; y < height; y++) {
//                                bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.GREEN : Color.WHITE);
                                bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                            }
                        }
                        imageView = (ImageView) findViewById(R.id.imgCodeQR);
                        imageView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(context, "Ingresa valores en el campo ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imageView.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGenerate.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
            }
        });
    }
}
