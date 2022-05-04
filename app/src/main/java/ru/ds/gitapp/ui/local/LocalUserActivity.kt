package ru.ds.gitapp.ui.local


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import ru.ds.gitapp.databinding.UserContentFragmentBinding


class LocalUserActivity : AppCompatActivity() {
    lateinit var binding: UserContentFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserContentFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


       with(binding){
           profileName.text = intent.getStringExtra("Name")
           profileEmail.text = intent.getStringExtra("email")
           profileImageView.load(intent.getStringExtra("image")
           )
       }

    }
}