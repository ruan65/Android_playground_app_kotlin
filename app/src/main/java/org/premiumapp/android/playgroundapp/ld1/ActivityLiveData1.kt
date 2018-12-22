package org.premiumapp.android.playgroundapp.ld1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.activity_live_data1.*
import org.premiumapp.android.playgroundapp.R

class ActivityLiveData1 : AppCompatActivity() {

    val liveData1 = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data1)

        btn_generate.setOnClickListener {
            val random = generateRandomNumber()
            liveData1.postValue(random.toString())
            tv_ld1_display.text = random.toString()
        }

        btn_fragment_control.setOnClickListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment_ld1, FragmentLd1())
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

    private fun setFragmentControlButtonText() {

        if (supportFragmentManager.backStackEntryCount == 0) {
            btn_fragment_control.text = "Add fragment"
        } else {
            btn_fragment_control.text = "Remove fragment"
        }
    }

    fun generateRandomNumber() = (100_000..1000_000).random()
}
