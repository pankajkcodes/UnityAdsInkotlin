package com.pankajkcodes.unityadsinkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()

    }


    private fun initializeComponents() {
        AdsManger(this).initialize()

        val adsLayout: LinearLayout = findViewById(R.id.layout_ad_container)

        findViewById<Button>(R.id.interstitial_ad).setOnClickListener {

            AdsManger(this).showInterstitial()
        }
        findViewById<Button>(R.id.rewarded).setOnClickListener {
            AdsManger(this).showRewarded()
        }
        findViewById<Button>(R.id.banner).setOnClickListener {

            AdsManger(this).showBanner(adsLayout)
        }
    }

}