package de.elasticbrains.sasexample

import android.app.Activity
import android.os.Bundle
import com.smartadserver.android.library.model.SASAdPlacement
import kotlinx.android.synthetic.main.activity_html_5.*

class HTML5AdActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html_5)
        val adPlacement = SASAdPlacement(311578, "1123523", 77061, null)
        html5Banner.loadAd(adPlacement)
    }

}