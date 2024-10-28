package com.prabirkundu.nativeandroidanimation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.prabirkundu.nativeandroidanimation.FlipAnimation.FlipAnimationJavaActivity
import com.prabirkundu.nativeandroidanimation.FlipAnimation.FlipAnimationKotlinActivity
import com.prabirkundu.nativeandroidanimation.databinding.ActivityFlipAnimationKotlinBinding
import com.prabirkundu.nativeandroidanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFlipKotlin.setOnClickListener{
            val intent = Intent(this@MainActivity,FlipAnimationKotlinActivity::class.java)
            startActivity(intent)
        }

        binding.btnFlipJava.setOnClickListener {
            val intent = Intent(this@MainActivity,FlipAnimationJavaActivity::class.java)
            startActivity(intent)
        }
    }
}