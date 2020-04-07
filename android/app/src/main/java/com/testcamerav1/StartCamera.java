package com.testcamerav1;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class StartCamera extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ViewGroup contentFrame;

    private ZXingScannerView mScannerView;
    public static final String G700x = "GPOS700";
    int StartCameraFlag = 0;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);
        startCamera();
    }
    public void startCamera(){

        contentFrame.setVisibility(View.VISIBLE);
        mScannerView.setResultHandler(this);
        mScannerView.setAutoFocus(true);

        if(Build.MODEL.equals(G700x)){
            if(StartCameraFlag == 0) {
                mScannerView.startCamera();
                StartCameraFlag = 1;
            }else {
                mScannerView.resumeCameraPreview(this);
            }
        }else{
            mScannerView.startCamera();
        }


    }


    @Override
    public void handleResult(Result result) { }


}
