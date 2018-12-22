package org.premiumapp.android.playgroundapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.premiumapp.android.playgroundapp.ld1.ActivityLiveData1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ld_1.setOnClickListener { startActivity(Intent(this, ActivityLiveData1::class.java)) }
    }
}
