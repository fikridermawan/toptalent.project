package com.project.toptalentapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.project.toptalentapp.R
import com.project.toptalentapp.adapter.OnboardingAdapter
import com.project.toptalentapp.fragment.Onboarding1Fragment
import com.project.toptalentapp.fragment.Onboarding2Fragment
import com.project.toptalentapp.fragment.Onboarding3Fragment

class OnboardingActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.vpOnboarding)

        val fragments: ArrayList<Fragment> = arrayListOf(
            Onboarding1Fragment(),
            Onboarding2Fragment(),
            Onboarding3Fragment()
        )

        val adapter = OnboardingAdapter(fragments, this)
        viewPager.adapter = adapter

    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
}