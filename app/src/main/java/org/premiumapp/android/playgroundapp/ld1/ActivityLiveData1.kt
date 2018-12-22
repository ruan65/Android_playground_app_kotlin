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

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment_ld1, FragmentLd1())
            .commit()

        btn_generate.setOnClickListener {
            val random = generateRandomNumber()
            liveData1.value = random.toString()
            tv_ld1_display.text = random.toString()
        }
    }

    public fun generateRandomNumber() = (100_000..1000_000).shuffled().last()
}
