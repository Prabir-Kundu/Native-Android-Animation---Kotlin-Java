package com.prabirkundu.nativeandroidanimation.FlipAnimation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.prabirkundu.nativeandroidanimation.R
import com.prabirkundu.nativeandroidanimation.databinding.ActivityFlipAnimationKotlinBinding

class FlipAnimationKotlinActivity : FragmentActivity() {
    lateinit var binding: ActivityFlipAnimationKotlinBinding
    var showingBack = false
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlipAnimationKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, CardFrontFragment())
                .commit()
        }
        button = findViewById(R.id.button)
        button.setOnClickListener{
            flipCard()
        }
    }

    class CardFrontFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = inflater.inflate(R.layout.fragment_card_front, container, false)
    }

    /**
     *   A fragment representing the back of the card.
     */
    class CardBackFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = inflater.inflate(R.layout.fragment_card_back, container, false)
    }


    private fun flipCard() {
        if (showingBack) {
            supportFragmentManager.popBackStack()
            showingBack = false
            return
        }

        // Flip to the back.

        showingBack = true

        // Create and commit a new fragment transaction that adds the fragment
        // for the back of the card, uses custom animations, and is part of the
        // fragment manager's back stack.

        supportFragmentManager.beginTransaction()

            // Replace the default fragment animations with animator
            // resources representing rotations when switching to the back
            // of the card, as well as animator resources representing
            // rotations when flipping back to the front, such as when the
            // system Back button is tapped.
            .setCustomAnimations(
                R.anim.card_flip_right_in,
                R.anim.card_flip_right_out,
                R.anim.card_flip_left_in,
                R.anim.card_flip_left_out
            )

            // Replace any fragments in the container view with a fragment
            // representing the next page, indicated by the just-incremented
            // currentPage variable.
            .replace(R.id.container, CardBackFragment())

            // Add this transaction to the back stack, letting users press
            // the Back button to get to the front of the card.
            .addToBackStack(null)

            // Commit the transaction.
            .commit()
    }
}