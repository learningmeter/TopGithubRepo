package com.codebitech.azad.view.ui.repodetail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.codebitech.azad.R
import com.codebitech.azad.data.local.GithubEntity
import com.codebitech.azad.data.remote.model.Items
import com.codebitech.azad.data.remote.response.Item
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    //private lateinit var githubEntity: GithubEntity
    private lateinit var githubEntity: Item
    private lateinit var titleTV: AppCompatTextView
    private lateinit var descTV: AppCompatTextView
    private lateinit var repoLink: AppCompatTextView
    private lateinit var starsTV: AppCompatTextView
    private lateinit var watchersTV: AppCompatTextView
    private lateinit var forksTV: AppCompatTextView
    private lateinit var langTV: AppCompatTextView
    private lateinit var imgLangTV: AppCompatTextView
    private lateinit var avatar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        githubEntity = intent.getParcelableExtra("INTENT_DATA")!!
        initViews()
        setData()
    }

    private fun initViews() {
        avatar = findViewById(R.id.item_profile_img)
        titleTV = findViewById(R.id.item_title)
        langTV = findViewById(R.id.item_language)
        imgLangTV = findViewById(R.id.item_img_language)
        repoLink = findViewById(R.id.repo_link)
        descTV = findViewById(R.id.desc)
        starsTV = findViewById(R.id.item_stars)
        watchersTV = findViewById(R.id.item_watchers)
        forksTV = findViewById(R.id.item_forks)
    }

    private fun setData() {
        Picasso.get()
            .load(githubEntity.owner?.avatar_url)
            .placeholder(R.drawable.ic_placeholder)
            .into(avatar)


        titleTV.text = githubEntity.full_name
        repoLink.text = githubEntity.releases_url
        descTV.text = githubEntity.description
        starsTV.text = githubEntity.stargazers_count.toString()

        repoLink.setMovementMethod(LinkMovementMethod.getInstance())
        repoLink.setOnClickListener {
            //val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(githubEntity.repoLink))
            //startActivity(browserIntent)
        }
    }

}
