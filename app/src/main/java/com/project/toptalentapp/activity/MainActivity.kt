package com.project.toptalentapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.project.toptalentapp.R
import com.project.toptalentapp.databinding.ActivityMainBinding
import com.project.toptalentapp.fragment.HomeFragment
import com.project.toptalentapp.fragment.JobListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(com.google.android.material.R.id.container, HomeFragment.newInstance("",""))

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> {
                    showFragment(com.google.android.material.R.id.container, HomeFragment.newInstance("", ""))
                }
                R.id.menu_joblist -> {
                    showFragment(com.google.android.material.R.id.container, JobListFragment.newInstance("", ""))
                }
            }
            true
        }
    }

    private fun showFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }
}