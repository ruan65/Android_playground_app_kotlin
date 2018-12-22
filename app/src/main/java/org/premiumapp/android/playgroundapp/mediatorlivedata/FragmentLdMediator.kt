package org.premiumapp.android.playgroundapp.mediatorlivedata

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_fragment_ld1.*

import org.premiumapp.android.playgroundapp.R

class FragmentLdMediator : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_fragment_mediator, container, false)

    private val changeLiveDataObserver = Observer<String> {
        it?.let { tv_fragment_mediator_display.text = it }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val liveDataA = (activity as ActivityLiveDataMediator).liveDataA
        val liveDataB = (activity as ActivityLiveDataMediator).liveDataB
        val mediatorLiveData = MediatorLiveData<String>()

        mediatorLiveData.addSource(liveDataA) { mediatorLiveData.value = "LD A: $it" }
        mediatorLiveData.addSource(liveDataB) { mediatorLiveData.value = "LD B: $it" }

        mediatorLiveData.observe(this, changeLiveDataObserver)
    }
}
