package org.premiumapp.android.playgroundapp.mediatorlivedata

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.activity_live_data_mediator.*
import org.premiumapp.android.playgroundapp.R

class ActivityLiveDataMediator : AppCompatActivity() {

    val liveDataA = MutableLiveData<String>()
    val liveDataB = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_mediator)
        title = "Mediator"

        btn_generate_A.setOnClickListener {
            val random = generateRandomNumber()
            liveDataA.postValue(random.toString())
            tv_ld1_display.text = random.toString()
        }

        btn_generate_B.setOnClickListener {
            val random = generateRandomNumber()
            liveDataB.postValue(random.toString())
            tv_ld1_display_B.text = random.toString()
        }

        btn_fragment_control.setOnClickListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment_ld1, FragmentLdMediator())
                    .addToBackStack("Fragment ld 1")
                    .commit()
            } else {
                supportFragmentManager.popBackStack()
            }
        }

        supportFragmentManager.addOnBackStackChangedListener {

            setFragmentControlButtonText()
        }
        setFragmentControlButtonText()
    }

    @SuppressLint("SetTextI18n")
    private fun setFragmentControlButtonText() {

        if (supportFragmentManager.backStackEntryCount == 0) {
            btn_fragment_control.text = "Add fragment"
        } else {
            btn_fragment_control.text = "Remove fragment"
        }
    }

    private fun generateRandomNumber() = (100_000..1000_000).random()
}
