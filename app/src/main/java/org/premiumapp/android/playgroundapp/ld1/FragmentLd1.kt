package org.premiumapp.android.playgroundapp.ld1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_fragment_ld1.*

import org.premiumapp.android.playgroundapp.R

class FragmentLd1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as ActivityLiveData1).liveData1.observe(this, changeLiveData1Observer)
        return inflater.inflate(R.layout.fragment_fragment_ld1, container, false)

    }

    private val changeLiveData1Observer = Observer<String> {
        it?.let { tv_fragment_mediator_display.text = it }
    }


}
