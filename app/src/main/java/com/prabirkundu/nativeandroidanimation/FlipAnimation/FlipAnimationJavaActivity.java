package com.prabirkundu.nativeandroidanimation.FlipAnimation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prabirkundu.nativeandroidanimation.R;
import com.prabirkundu.nativeandroidanimation.databinding.ActivityFlipAnimationKotlinBinding;

public class FlipAnimationJavaActivity extends AppCompatActivity {
    ActivityFlipAnimationKotlinBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlipAnimationKotlinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }


}
