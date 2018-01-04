package com.example.fedor.a4mulator.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.fedor.a4mulator.R;

public class CamFragment extends Dialog implements View.OnClickListener {

    public MainActivity c;
    public Dialog d;
    public Button cam,gal,del;

    public CamFragment(MainActivity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choose_photo_fragment);
        cam = (Button) findViewById(R.id.btn_from_camera);
        gal = (Button) findViewById(R.id.btn_from_gallery);
        del = (Button) findViewById(R.id.btn_delete_avatar);
        cam.setOnClickListener(this);
        cam.clearAnimation();

        gal.setOnClickListener(this);
        gal.clearAnimation();

        del.setOnClickListener(this);
        del.clearAnimation();



    }

    @Override
    public void onClick(View v) {
        final int REQUEST_IMAGE_CAPTURE = 1;
        switch (v.getId()) {
            case R.id.btn_from_camera:
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePicture.resolveActivity(c.getPackageManager()) != null) {
                    c.startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
                }

                dismiss();
                break;
            case R.id.btn_from_gallery:
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                c.startActivityForResult(pickPhoto , 2);//one can be replaced with any action code
                dismiss();
                break;
            case R.id.btn_delete_avatar:
                c.deleteAvatar();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }

}