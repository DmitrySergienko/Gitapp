package ru.ds.gitapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ds.gitapp.databinding.ProfileContentBinding



class ContentActivity : AppCompatActivity() {
    lateinit var binding: ProfileContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProfileContentBinding.inflate(layoutInflater)
        setContentView(binding.root)


       with(binding){
           profileName.text = intent.getStringExtra("Name")
           profileEmail.text = intent.getStringExtra("email")
           profileImageView.setImageResource(intent.getIntExtra("image",R.drawable.ic_profile))
       }



    }
}