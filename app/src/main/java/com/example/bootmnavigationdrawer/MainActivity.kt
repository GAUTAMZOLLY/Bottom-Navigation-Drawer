package com.example.bootmnavigationdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bootmnavigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var   binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationId.setOnItemSelectedListener { MenuItem ->
         when(MenuItem.itemId){
               R.id.bottom_Home  ->  {
                     goToFragment(HomeFragment())
                   true
               }
             R.id.bottom_setting ->  {
                   goToFragment(SettingFragment())
                 true
             }

             R.id.bottom_share ->  {
                   goToFragment(ShareFragment())
                  true
             }
             else  ->  {
                   false
             }
         }
        }
    }
     private   fun goToFragment(fragment: Fragment)  {
           val fragmentManager  =  supportFragmentManager
         fragmentManager.beginTransaction().replace(R.id.fragment_container ,
              fragment).commit()
     }
}