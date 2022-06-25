package com.codebitech.azad.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.codebitech.azad.R
import com.codebitech.azad.data.local.GithubEntity
import com.codebitech.azad.data.remote.model.Items
import com.codebitech.azad.view.ui.repodetail.DetailsActivity
import com.squareup.picasso.Picasso
import androidx.core.util.Pair
import com.codebitech.azad.data.remote.response.Item
import com.codebitech.azad.data.remote.response.Owner

class TopRepoAdapter(
    val context: Activity,
    private val rowLayout: Int,
    private val repositories: List<Item>
) : RecyclerView.Adapter<TopRepoAdapter.RepositoryViewHolder>() {

    class RepositoryViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        internal var repoName: AppCompatTextView = view.findViewById(R.id.repo_name)
        internal var username: AppCompatTextView = view.findViewById(R.id.username)
        internal var avatar: ImageView = view.findViewById(R.id.avatar_iv)
        internal var cardView: CardView = view.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.repoName.text = repositories[position].full_name
        val avatar = repositories[position].owner?.avatar_url

        Picasso
            .get()
            .load(avatar)
            .placeholder(android.R.drawable.sym_def_app_icon)
            .error(android.R.drawable.sym_def_app_icon)
            .into(holder.avatar)

        val arr = repositories[position].full_name.split("/").toTypedArray()
        val username = arr[0]
        holder.username.text = username

        holder.cardView.setOnClickListener {

            val intent = Intent(context, DetailsActivity::class.java)

            val githubEntity = repositories[position]
            intent.putExtra("INTENT_DATA", githubEntity)

            val p1 = Pair.create<View?, String?>(holder.avatar, "image")
            val p2 = Pair.create<View?, String?>(holder.repoName, "text")
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context, p1, p2)
            ActivityCompat.startActivity(context, intent, options.toBundle())
        }
    }


    override fun getItemCount(): Int {
        return repositories.size
    }

}