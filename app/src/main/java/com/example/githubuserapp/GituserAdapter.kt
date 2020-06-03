package com.example.githubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GituserAdapter(private var context: Context, private var listener: OnUserClickListener) :
    BaseAdapter() {
    internal var gitusers = arrayListOf<Gituser>()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.gituser, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val gituser = getItem(position) as Gituser
        viewHolder.bind(gituser, listener, position)
        return itemView
    }

    override fun getItem(position: Int): Any = gitusers[position]


    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = gitusers.size


    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.tv_name)
        private val txtDesc: TextView = view.findViewById(R.id.tv_desc)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)
        private val txtCompany: TextView? = view.findViewById(R.id.tv_company)
        private val txtLocation: TextView? = view.findViewById(R.id.tv_location)
        private val txtRepo: TextView? = view.findViewById(R.id.tv_repo)
        private val txtFollower: TextView? = view.findViewById(R.id.tv_followers2)
        private val txtFollowin: TextView? = view.findViewById(R.id.tv_following2)
        private val itView = view


        internal fun bind(gituser: Gituser, listener: OnUserClickListener, position: Int) {
            txtName.text = gituser.name
            txtDesc.text = gituser.description
            imgPhoto.setImageResource(gituser.photo)
            txtCompany?.text = gituser.company
            txtLocation?.text = gituser.location
            txtRepo?.text = gituser.repo
            txtFollower?.text = gituser.follower
            txtFollowin?.text = gituser.followin

            txtName.setOnClickListener {
                listener.onUserClick(gituser)
            }
            itView.setOnClickListener {
                listener.onUserClick(gituser)
            }


        }


    }


}

interface OnUserClickListener {
    fun onUserClick(user: Gituser)
}