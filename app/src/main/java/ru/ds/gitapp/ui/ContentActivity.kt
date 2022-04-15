package ru.ds.gitapp.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ds.gitapp.R
import ru.ds.gitapp.databinding.UserContentFragmentBinding


class ContentActivity : AppCompatActivity() {
    lateinit var binding: UserContentFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserContentFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


       with(binding){
           profileName.text = intent.getStringExtra("Name")
           profileEmail.text = intent.getStringExtra("email")
           profileImageView.setImageResource(intent.getIntExtra("image",
               R.drawable.ic_profile_icon1
           ))
       }

    }
}