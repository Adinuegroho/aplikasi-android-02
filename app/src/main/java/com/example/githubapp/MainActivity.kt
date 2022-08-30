package com.example.githubapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<User>()
    private var title: String = "Github User"
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBar(title)

        binding.rvUsers.setHasFixedSize(true)

        list.addAll(listUser)
        showRecylerList()
    }


    private val listUser: ArrayList<User>
    get() {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataUsername = resources.getStringArray(R.array.data_username)
        val dataImage = resources.obtainTypedArray(R.array.data_img)
        val dataFollow = resources.getIntArray(R.array.data_follow)
        val dataFollower = resources.getIntArray(R.array.data_follower)
        val dataRepository = resources.getIntArray(R.array.data_repository)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataCompany = resources.getStringArray(R.array.data_company)

        val listUser = ArrayList<User>()
        for (i in dataName.indices) {
            val user = User(dataName[i],
                dataUsername[i],
                dataImage.getResourceId(i, -1),
                dataFollow[i],
                dataFollower[i],
                dataRepository[i],
                dataLocation[i],
                dataCompany[i])
            listUser.add(user)
        }
        return listUser
    }

    private fun setActionBar(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecylerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvUsers.layoutManager = LinearLayoutManager(this)
        }

        val listUserAdapter = ListUserAdapter(list)
        binding.rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(DetailActivity.EXTRA_USER, data)
                startActivity(intentToDetail)
            }
        })
    }
}