package com.example.githubuserapp

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnUserClickListener {

    private var gituserAdapter = GituserAdapter(this, this)
    private lateinit var dataName: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepo: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowin: Array<String>

    private var gitusers = arrayListOf<Gituser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView? = findViewById(R.id.lv_gituser)
        listView?.adapter = gituserAdapter

        perpare()
        addItem()

        listView?.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, gitusers[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val gituser = Gituser(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDesc[position],
                dataCompany[position],
                dataLocation[position],
                dataRepo[position],
                dataFollower[position],
                dataFollowin[position]

            )
            this.gitusers.add(gituser)
        }
        gituserAdapter.gitusers = gitusers
    }

    private fun perpare() {
        dataName = resources.getStringArray(R.array.name)
        dataDesc = resources.getStringArray(R.array.username)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepo = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowin = resources.getStringArray(R.array.following)

    }

    override fun onUserClick(user: Gituser) {
        val intent = Intent(this, DetailUserActivity::class.java)
        intent.putExtra("USERIMAGE", user.photo.toString())
        intent.putExtra("DETAILUSERNAME", user.name)
        intent.putExtra("USERNAME", user.description)
        intent.putExtra("USERCOMPANY", user.company)
        intent.putExtra("USERLOCATION", user.location)
        intent.putExtra("USERREPO", user.repo)
        intent.putExtra("USERFOLLOWER", user.follower)
        intent.putExtra("USERFOLLOWIN", user.followin)
        startActivity(intent)

    }
}
