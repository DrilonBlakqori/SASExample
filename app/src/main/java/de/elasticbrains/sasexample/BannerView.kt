package de.elasticbrains.sasexample

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.smartadserver.android.library.model.SASAdElement
import com.smartadserver.android.library.ui.SASBannerView
import java.lang.Exception

/**
 * A wrapper around SASBannerView. Use this for showing ads
 */
class BannerView(context: Context, attributeSet: AttributeSet? = null) : SASBannerView(context, attributeSet),
    SASBannerView.BannerListener {


    init {
        bannerListener = this
    }

    override fun onBannerAdClicked(bannerView: SASBannerView?) {
        Log.i("BannerView","onBannerAdClicked $bannerView")
    }

    override fun onBannerAdLoaded(bannerView: SASBannerView?, adElement: SASAdElement?) {
        Log.i("BannerView","onBannerAdLoaded")
        // Resize according to http://documentation.smartadserver.com/displaySDK/android/integration/banner.html#adviewresize
        executeOnUIThread {
            val optimalHeight = optimalHeight
            layoutParams.height = optimalHeight
            layoutParams = layoutParams
//            Invalidating or calling requestLayout has no effect
//            invalidate()
//            requestLayout()
            Log.i("BannerView","layout params updated")
        }
    }

    override fun onBannerAdCollapsed(bannerView: SASBannerView?) {
        Log.i("BannerView","onBannerAdCollapsed")
    }

    override fun onBannerAdClosed(bannerView: SASBannerView?) {
        Log.i("BannerView","onBannerAdClosed")
    }

    override fun onBannerAdResized(bannerView: SASBannerView?) {
        Log.i("BannerView","onBannerAdResized")
    }

    override fun onBannerAdExpanded(bannerView: SASBannerView?) {
        Log.i("BannerView","onBannerAdExpanded")
    }

    override fun onBannerAdVideoEvent(bannerView: SASBannerView?, id: Int) {
        Log.i("BannerView","onBannerAdVideoEvent")
    }

    override fun onBannerAdFailedToLoad(bannerView: SASBannerView?, exception: Exception?) {
        Log.i("BannerView","onBannerAdFailedToLoad $exception")
    }
}