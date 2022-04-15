package ru.ds.gitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ds.gitapp.databinding.ActivityMainBinding

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

                R.id.bottom_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment()).commit()
                    true
                }
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