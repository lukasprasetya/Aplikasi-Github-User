package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

//        cv_avatar.setImageResource(intent.getStringExtra("USERIMAGE").toInt())
//        tv_namedetail.text = intent.getStringExtra("DETAILUSERNAME")
//        tv_username.text = intent.getStringExtra("USERNAME")
//        tv_company.text = intent.getStringExtra("USERCOMPANY")
//        tv_location.text = intent.getStringExtra("USERLOCATION")
//        tv_repo.text = intent.getStringExtra("USERREPO")
//        tv_followers2.text = intent.getStringExtra("USERFOLLOWER")
//        tv_following2.text = intent.getStringExtra("USERFOLLOWIN")


        val user = intent.getParcelableExtra(EXTRA_USER) as Gituser

        val usrImg = findViewById<ImageView>(R.id.cv_avatar)
        val detailUsername = findViewById<TextView>(R.id.tv_namedetail)
        val username = findViewById<TextView>(R.id.tv_username)
        val userCompany = findViewById<TextView>(R.id.tv_company)
        val userLocation = findViewById<TextView>(R.id.tv_location)
        val userRepo = findViewById<TextView>(R.id.tv_repo)
        val userFollower = findViewById<TextView>(R.id.tv_followers2)
        val userFollowin = findViewById<TextView>(R.id.tv_following2)

        usrImg.setImageResource(user.photo)
        detailUsername.text = user.name
        username.text = user.description
        userCompany.text = user.company
        userLocation.text = user.location
        userRepo.text = user.repo
        userFollower.text = user.follower
        userFollowin.text = user.followin


    }
}
