package com.dengage.android.kotlin.nawaz.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.dengage.android.kotlin.nawaz.R
import com.dengage.sdk.DengageManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DengageManager.getInstance(this).setNavigation(this@MainActivity)

    }


    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.navigationHostFragment).navigateUp()

}