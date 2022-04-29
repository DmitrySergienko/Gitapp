package ru.ds.gitapp.ui.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.ds.gitapp.R
import ru.ds.gitapp.data.remote.GitUserEntity
import ru.ds.gitapp.databinding.ActivityMainBinding
import ru.ds.gitapp.ui.gitusers.GitUsersFragment
import ru.ds.gitapp.ui.users.ItemUserFragment

//для получения вложенного фрагмена через контракт
    // наследуемся от GitUsersFragment.Controller

class MainActivity : AppCompatActivity(), GitUsersFragment.Controller {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            initBottomNavigation()
        }
    }


    private fun initBottomNavigation() {

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_local -> {

                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, MainFragment()).commit()
                    true
                }

                R.id.bottom_git -> {
                    var gitUsersFragment: Fragment = GitUsersFragment()
                    //gitUsersFragment.retainInstance = true //команда помогает не разрушать данный фрагмент
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, GitUsersFragment()).commit()

                    true
                }
                else -> true
            }
        }
        //default view
        binding.bottomNavigationView.selectedItemId = R.id.bottom_git
    }

    //для получения вложенного фрагмена через контракт
    // наследуемся от GitUsersFragment.Controller
   override fun onShowUserDetails(user: GitUserEntity) {

       supportFragmentManager
           .beginTransaction()
           .addToBackStack(null) //для возвращения на предидущий фрагмент
           .replace(binding.container.id, ItemUserFragment.newInstance(user))
           .commit()

   }
}