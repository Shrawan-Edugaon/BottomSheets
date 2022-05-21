package com.example.bottomsheets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheet:View = findViewById(R.id.bottomSheet)
        val bottomSheetBehavior: BottomSheetBehavior<View> = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object:BottomSheetBehavior.BottomSheetCallback()
        {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Toast.makeText(applicationContext,"OnSlide Function called..",Toast.LENGTH_SHORT).show()
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {

                when(newState)
                {
                    BottomSheetBehavior.STATE_DRAGGING->Toast.makeText(applicationContext,"BottomSheetBehavior.STATE_DRAGGING",Toast.LENGTH_SHORT).show()

                    BottomSheetBehavior.STATE_EXPANDED->Toast.makeText(applicationContext,"BottomSheetBehavior.STATE_DRAGGING",Toast.LENGTH_SHORT).show()

                    BottomSheetBehavior.STATE_COLLAPSED->Toast.makeText(applicationContext,"BottomSheetBehavior.STATE_DRAGGING",Toast.LENGTH_SHORT).show()

                    BottomSheetBehavior.STATE_HIDDEN->Toast.makeText(applicationContext,"BottomSheetBehavior.STATE_DRAGGING",Toast.LENGTH_SHORT).show()

                    BottomSheetBehavior.STATE_SETTLING->Toast.makeText(applicationContext,"BottomSheetBehavior.STATE_DRAGGING",Toast.LENGTH_SHORT).show()
                }
            }
        })

        val button:Button = findViewById(R.id.button)

        button.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED)
            {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else
            {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }
}