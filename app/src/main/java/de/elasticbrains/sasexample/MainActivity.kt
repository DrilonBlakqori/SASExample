package de.elasticbrains.sasexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.smartadserver.android.library.model.SASAdPlacement
import com.smartadserver.android.library.util.SASConfiguration
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: Activity () {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SASConfiguration.getSharedInstance().configure(this, 311478, "https://mobile.smartadserver.com");

        val adPlacement = SASAdPlacement(311578, "1123762", 73927, null)
        bannerView.loadAd(adPlacement)

        theButton.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }

}