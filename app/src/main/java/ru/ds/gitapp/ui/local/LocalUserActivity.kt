package ru.ds.gitapp.ui.local


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import ru.ds.gitapp.databinding.LocalUserActivityBinding



class LocalUserActivity : AppCompatActivity() {
    lateinit var binding: LocalUserActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LocalUserActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


       with(binding){
           profileName.text = intent.getStringExtra("Name")
           profileEmail.text = intent.getStringExtra("email")
           profileImageView.load(intent.getStringExtra("image")
           )
       }

    }
}