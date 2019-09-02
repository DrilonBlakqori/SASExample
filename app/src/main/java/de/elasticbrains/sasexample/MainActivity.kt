package de.elasticbrains.sasexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.smartadserver.android.library.model.SASAdElement
import com.smartadserver.android.library.util.SASConfiguration
import com.smartadserver.android.library.model.SASAdPlacement
import com.smartadserver.android.library.ui.SASBannerView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception


class MainActivity: Activity (), SASBannerView.BannerListener {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SASConfiguration.getSharedInstance().configure(this, 311478, "https://mobile.smartadserver.com");

        val adPlacement = SASAdPlacement(311578, "1123762", 73927, null)
        bannerView.bannerListener = this
        bannerView.loadAd(adPlacement)

        theButton.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }

    override fun onBannerAdClicked(bannerView: SASBannerView?) {
        Log.i("MainActivity","onBannerAdClicked $bannerView")
    }

    override fun onBannerAdLoaded(bannerView: SASBannerView?, adElement: SASAdElement?) {
        Log.i("MainActivity","onBannerAdLoaded")
    }

    override fun onBannerAdCollapsed(bannerView: SASBannerView?) {
        Log.i("MainActivity","onBannerAdCollapsed")
    }

    override fun onBannerAdClosed(bannerView: SASBannerView?) {
        Log.i("MainActivity","onBannerAdClosed")
    }

    override fun onBannerAdResized(bannerView: SASBannerView?) {
        Log.i("MainActivity","onBannerAdResized")
    }

    override fun onBannerAdExpanded(bannerView: SASBannerView?) {
        Log.i("MainActivity","onBannerAdExpanded")
    }

    override fun onBannerAdVideoEvent(bannerView: SASBannerView?, id: Int) {
        Log.i("MainActivity","onBannerAdVideoEvent")
    }

    override fun onBannerAdFailedToLoad(bannerView: SASBannerView?, exception: Exception?) {
        Log.i("MainActivity","onBannerAdFailedToLoad $exception")
    }
}