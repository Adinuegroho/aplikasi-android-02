package com.example.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var title: String = "Detail"

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBar(title)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val textUsername = "@${user.username}"
        val textFollow = "Diikuti : ${user.follow}"
        val textFollower ="Pengikut : ${user.follower}K"

        binding.tvItemName.text = user.name
        binding.tvItemUsername.text = textUsername
        binding.imgItemUser.setImageResource(user.image)
        binding.tvItemFollow.text = textFollow
        binding.tvItemFollower.text = textFollower
        binding.tvItemRepository.text = user.repository.toString()
        binding.tvItemLocation.text = user.location
        binding.tvItemCompany.text = user.company
    }

    private fun setActionBar(title: String) {
        supportActionBar?.title = title
    }
}