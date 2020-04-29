package com.example.onecheck;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ReceiptActivity extends AppCompatActivity {

    Button takePictureButton, albumButton;
    ImageView displayPicture;
    private static final int PICK_IMAGE = 100;
    private static final int TAKE_PICTURE = 101;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        takePictureButton = (Button) findViewById(R.id.takePictureButton);
        albumButton = (Button) findViewById(R.id.albumButton);
        displayPicture = (ImageView) findViewById(R.id.displayPicture);

        //Request camera permissions
        if (ContextCompat.checkSelfPermission(ReceiptActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ReceiptActivity.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }


        takePictureButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        //open the real camera app
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, TAKE_PICTURE);

                        //sets imageview to a stored picture of a receipt for demo purposes
                        //displayPicture.setImageResource(R.drawable.receipt);
                    }
                });

        albumButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        openGallery();
                    }
                });
    }

    //open photo album
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


    //set the ImageView to the selected picture from album
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            displayPicture.setImageURI(imageUri);
        } else if(resultCode == RESULT_OK && requestCode == TAKE_PICTURE) {
            //Get Capture Image
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            //Set ImageView to Capture Image
            displayPicture.setImageBitmap(captureImage);
        }
    }

    public void launchCombinedActivity(View view) {
        Intent intent = new Intent(this, CombinedActivity.class);
        startActivity(intent);
    }
}
