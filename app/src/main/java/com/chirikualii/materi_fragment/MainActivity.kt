package com.chirikualii.materi_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.chirikualii.materi_fragment.databinding.ActivityMainBinding
import com.chirikualii.materi_fragment.favorite.FavoriteFragment
import com.chirikualii.materi_fragment.home.HomeFragment
import com.chirikualii.materi_fragment.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    private val favoriteFragment = FavoriteFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setCurrentFragment(homeFragment)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuHome -> {
                    setCurrentFragment(homeFragment)
                    true
                }

                R.id.menuFavorite -> {
                    setCurrentFragment(favoriteFragment)
                    true
                }

                R.id.menuProfile -> {
                    setCurrentFragment(profileFragment)
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(
            R.id.fragmentContainer,fragment
        )
        fragmentTransaction.commit()

    }

}