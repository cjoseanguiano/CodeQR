package com.devix.codeqr;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.devix.codeqr_chat_bsd.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class AnexoMain extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView zXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anexo_main);
    }

    public void scannQR(View view) {
        zXingScannerView = new ZXingScannerView(this);
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void handleResult(Result result) {
        Log.e("handler", result.getText());
        Log.e("handler", result.getBarcodeFormat().toString());

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Resultado Scann");
        alertBuilder.setMessage(result.getText());
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();

    }
}
