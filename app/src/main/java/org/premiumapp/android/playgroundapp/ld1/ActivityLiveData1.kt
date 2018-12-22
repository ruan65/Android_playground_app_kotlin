package org.premiumapp.android.playgroundapp.ld1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.premiumapp.android.playgroundapp.R

class ActivityLiveData1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data1)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment_ld1, FragmentLd1())
            .commit()
    }
}
