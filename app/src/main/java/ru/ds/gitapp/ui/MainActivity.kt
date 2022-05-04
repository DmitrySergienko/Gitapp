package ru.ds.gitapp.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.ds.gitapp.R
import ru.ds.gitapp.databinding.ActivityMainBinding
import ru.ds.gitapp.domain.GitHubEntity
import ru.ds.gitapp.ui.gitrepo.RepositoryFragment
import ru.ds.gitapp.ui.gitusers.UserFragment
import ru.ds.gitapp.ui.local.LocalUserFragment

//для получения вложенного фрагмена через контракт
    // наследуемся от GitUsersFragment.Controller

class MainActivity : AppCompatActivity(), RepositoryFragment.Controller {

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
                        .replace(R.id.container, LocalUserFragment()).commit()
                    true
                }

                R.id.bottom_git -> {
                    var gitUsersFragment: Fragment = RepositoryFragment()
                    //gitUsersFragment.retainInstance = true //команда помогает не разрушать данный фрагмент
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, RepositoryFragment()).commit()

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
   override fun onShowUserDetails(user: GitHubEntity) {

       supportFragmentManager
           .beginTransaction()
           .addToBackStack(null) //для возвращения на предидущий фрагмент
           .replace(binding.container.id, UserFragment.newInstance(user))
           .commit()

   }
}