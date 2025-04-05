package com.example.task1;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView; // ✅ Declare the ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button rotateButton = findViewById(R.id.rotateButton);

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
                rotation.setDuration(1000); // 1 second
                rotation.start();
            }
        });

        findViewById(R.id.openBottomSheet).setOnClickListener(v -> showBottomSheet());
    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet_menu, null);
        bottomSheetDialog.setContentView(view);

        // Handle click events
        view.findViewById(R.id.profile).setOnClickListener(v -> bottomSheetDialog.dismiss());
        view.findViewById(R.id.settings).setOnClickListener(v -> bottomSheetDialog.dismiss());
        view.findViewById(R.id.logout).setOnClickListener(v -> bottomSheetDialog.dismiss());

        bottomSheetDialog.show();
    }
}
