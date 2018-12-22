package org.premiumapp.android.playgroundapp.ld2transformation


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.android.synthetic.main.fragment_fragment_ld1.*
import org.premiumapp.android.playgroundapp.R

class FragmentLd2Transformation : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_ld2_transformation, container, false)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val liveData = (activity as ActivityLiveData2Transformation).liveData
        Transformations.map(liveData) { "Random: $it" }
            .observe(this, changeLiveData1Observer)

    }

    private val changeLiveData1Observer = Observer<String> {
        it?.let { tv_fragment_mediator_display.text = it }
    }


}
