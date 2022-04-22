package ru.ds.gitapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ds.gitapp.R
import ru.ds.gitapp.databinding.ActivityMainBinding
import ru.ds.gitapp.ui.gitusers.AboutFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }


    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.bottom_main -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MainFragment()).commit()
                    true
                }

               //R.id.bottom_git_users -> {
               //    supportFragmentManager.beginTransaction()
               //        .replace(R.id.container, GitUsersFragment()).commit()
               //    true
               //}
                R.id.bottom_about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, AboutFragment()).commit()
                    true
                }
                else -> true
            }
        }
        //default view
        binding.bottomNavigationView.selectedItemId = R.id.bottom_main
    }
}