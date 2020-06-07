package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        cv_avatar.setImageResource(intent.getStringExtra("USERIMAGE").toInt())
        tv_namedetail.text = intent.getStringExtra("DETAILUSERNAME")
        tv_username.text = intent.getStringExtra("USERNAME")
        tv_company.text = intent.getStringExtra("USERCOMPANY")
        tv_location.text = intent.getStringExtra("USERLOCATION")
        tv_repo.text = intent.getStringExtra("USERREPO")
        tv_followers2.text = intent.getStringExtra("USERFOLLOWER")
        tv_following2.text = intent.getStringExtra("USERFOLLOWIN")


    }
}
