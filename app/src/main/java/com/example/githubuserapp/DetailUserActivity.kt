package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        cv_avatar.setImageResource(getIntent().getStringExtra("USERIMAGE").toInt())
        tv_namedetail.text = getIntent().getStringExtra("DETAILUSERNAME")
        tv_username.text = getIntent().getStringExtra("USERNAME")
        tv_company.text = getIntent().getStringExtra("USERCOMPANY")
        tv_location.text = getIntent().getStringExtra("USERLOCATION")
        tv_repo.text = getIntent().getStringExtra("USERREPO")
        tv_followers2.text=getIntent().getStringExtra("USERFOLLOWER")
        tv_following2.text=getIntent().getStringExtra("USERFOLLOWIN")


    }
}
