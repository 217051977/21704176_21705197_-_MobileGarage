package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_filter_options.*
import pt.ulusofona.cm.mobilegarage.R

class FilterOptionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_filter_options,
            container,
            false
        )
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        filter_distance_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var progressValue: Int = 0
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressValue = progress
                val value: String = "${progress}m"
                filter_distance_value.text = value
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                println("")
                /*TODO get the value*/
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                println("")
            }
        })
    }

}