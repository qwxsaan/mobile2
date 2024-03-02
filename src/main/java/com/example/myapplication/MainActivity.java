package com.example.myapplication;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Instrumentation;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.content.Intent;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ConstraintLayoutBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayoutBinding binding = ConstraintLayoutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.oplatabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", R.drawable.picc3);
                start.launch(intent);

            }
            ActivityResultLauncher<Intent> start = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Bundle image = result.getData().getExtras();
                    ImageView imageView = findViewById(R.id.image);
                    int imageResource = image.getInt("image");
                    imageView.setImageResource(imageResource);
                }});
        });

    }







    }

