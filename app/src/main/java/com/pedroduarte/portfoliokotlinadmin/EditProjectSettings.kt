package com.pedroduarte.portfoliokotlinadmin

import android.annotation.SuppressLint
import android.os.Bundle
import android.system.Os
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.pedroduarte.portfoliokotlinadmin.editsettings.Fun
import com.pedroduarte.portfoliokotlinadmin.editsettings.Learn
import com.pedroduarte.portfoliokotlinadmin.editsettings.Learn_Fun
import com.pedroduarte.portfoliokotlinadmin.editsettings.OsFragment
import com.pedroduarte.portfoliokotlinadmin.editsettings.OsLinkFragment

class EditProjectSettings : AppCompatActivity() {

    private lateinit var tabs: TabLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_project_settings)


        tabs = findViewById(R.id.tabLayout)

        val funn = Fun()
        val learn = Learn()
        val learn_fun = Learn_Fun()
        val learn_ = OsFragment()
        val learn_links = OsLinkFragment()


        tabs.addOnTabSelectedListener(object: OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {

                            when (tab.text){
                                "Fun" -> {
                                    supportFragmentManager.beginTransaction()
                                        .replace( R.id.framelayout, funn)
                                        .addToBackStack("tag")
                                        .commit()
                                }

                                "Learn" -> {
                                    supportFragmentManager.beginTransaction()
                                        .replace( R.id.framelayout, learn)
                                        .addToBackStack("tag")
                                        .commit()
                                }

                                "Learn Fun" -> {
                                    supportFragmentManager.beginTransaction()
                                        .replace( R.id.framelayout, learn_fun)
                                        .addToBackStack("tag")
                                        .commit()
                                }

                                "OS" -> {
                                    supportFragmentManager.beginTransaction()
                                        .replace( R.id.framelayout, learn_)
                                        .addToBackStack("tag")
                                        .commit()
                                }

                                "OS Links" -> {
                                    supportFragmentManager.beginTransaction()
                                        .replace( R.id.framelayout, learn_links)
                                        .addToBackStack("tag")
                                        .commit()
                                }

                                else -> {
                                    Toast.makeText(applicationContext,"kkk "+tab.text,Toast.LENGTH_SHORT).show()
                                }
                            }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })


        supportFragmentManager.beginTransaction()
            .replace( R.id.framelayout, funn)
            .addToBackStack("tag")
            .commit()



    }
}