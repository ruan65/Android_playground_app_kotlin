package org.premiumapp.android.playgroundapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.premiumapp.android.playgroundapp.ld1.ActivityLiveData1
import org.premiumapp.android.playgroundapp.ld2transformation.ActivityLiveData2Transformation
import org.premiumapp.android.playgroundapp.mediatorlivedata.ActivityLiveDataMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ld_1.setOnClickListener { startActivity(Intent(this, ActivityLiveData1::class.java)) }
        btn_ld_2.setOnClickListener { startActivity(Intent(this, ActivityLiveData2Transformation::class.java)) }
        btn_mediator.setOnClickListener { startActivity(Intent(this, ActivityLiveDataMediator::class.java)) }
    }
}
