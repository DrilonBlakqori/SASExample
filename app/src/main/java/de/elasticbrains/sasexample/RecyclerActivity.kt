package de.elasticbrains.sasexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartadserver.android.library.model.SASAdPlacement
import com.smartadserver.android.library.ui.SASBannerView

import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ARecyclerAdapter()
    }
}


class ARecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val adPlacement = SASAdPlacement(311578, "1123762", 73927, null)

    override fun getItemViewType(position: Int): Int {
        return if (position == 3) {
            R.layout.item_ad
        } else {
            R.layout.item_dummy
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return when (viewType) {
            R.layout.item_ad -> {
                AdViewHolder(view)
            } else -> {
                DummyViewHolder(view)
            }
        }
    }

    override fun getItemCount() = 20

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == R.layout.item_ad) {
            holder.itemView.findViewById<SASBannerView>(R.id.recyclerBannerView).loadAd(adPlacement)
        } else {
            holder.itemView.findViewById<TextView>(R.id.textView).text = when (position) {
                2 -> "Ad appears below this item"
                4 -> "Ad appears above this item"
                else -> "Dummy item"
            }
        }
    }

    class AdViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    class DummyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}