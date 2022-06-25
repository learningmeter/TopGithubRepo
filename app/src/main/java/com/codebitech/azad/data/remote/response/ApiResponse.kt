package com.codebitech.azad.data.remote.response

import android.os.Parcel
import android.os.Parcelable

data class GitResponse(
        val total_count: Int,
        val incomplete_results: Boolean,
        val items: List<Item>
)

data class Item(
        val id: Int,
        val node_id: String,
        val name: String,
        val full_name: String,
        val owner: Owner,
        val private: Boolean,
        val html_url: String,
        val description: String,
        val fork: Boolean,
        val url: String,
        val forks_url: String,
        val keys_url: String,
        val collaborators_url: String,
        val teams_url: String,
        val hooks_url: String,
        val issue_events_url: String,
        val events_url: String,
        val assignees_url: String,
        val branches_url: String,
        val tags_url: String,
        val blobs_url: String,
        val git_tags_url: String,
        val git_refs_url: String,
        val trees_url: String,
        val statuses_url: String,
        val languages_url: String,
        val stargazers_url: String,
        val contributors_url: String,
        val subscribers_url: String,
        val subscription_url: String,
        val commits_url: String,
        val git_commits_url: String,
        val comments_url: String,
        val issue_comment_url: String,
        val contents_url: String,
        val compare_url: String,
        val merges_url: String,
        val archive_url: String,
        val downloads_url: String,
        val issues_url: String,
        val pulls_url: String,
        val milestones_url: String,
        val notifications_url: String,
        val labels_url: String,
        val releases_url: String,
        val deployments_url: String,
        val created_at: String,
        val updated_at: String,
        val pushed_at: String,
        val git_url: String,
        val ssh_url: String,
        val clone_url: String,
        val svn_url: String,
        val homepage: String,
        val size: Int,
        val stargazers_count: Int,
        val watchers_count: Int,
        val language: String,
        val has_issues: Boolean,
        val has_projects: Boolean,
        val has_downloads: Boolean,
        val has_wiki: Boolean,
        val has_pages: Boolean,
        val forks_count: Int,
        val mirror_url: Any,
        val archived: Boolean,
        val open_issues_count: Int,
        val license: License,
        val forks: Int,
        val open_issues: Int,
        val watchers: Int,
        val default_branch: String,
        val score: Double
): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readParcelable(Owner::class.java.classLoader)!!,
                parcel.readByte() != 0.toByte(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readByte() != 0.toByte(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readByte() != 0.toByte(),
                parcel.readByte() != 0.toByte(),
                parcel.readByte() != 0.toByte(),
                parcel.readByte() != 0.toByte(),
                parcel.readByte() != 0.toByte(),
                parcel.readInt(),
                TODO("mirror_url"),
                parcel.readByte() != 0.toByte(),
                parcel.readInt(),
                TODO("license"),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readDouble()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(node_id)
                parcel.writeString(name)
                parcel.writeString(full_name)
                parcel.writeParcelable(owner, flags)
                parcel.writeByte(if (private) 1 else 0)
                parcel.writeString(html_url)
                parcel.writeString(description)
                parcel.writeByte(if (fork) 1 else 0)
                parcel.writeString(url)
                parcel.writeString(forks_url)
                parcel.writeString(keys_url)
                parcel.writeString(collaborators_url)
                parcel.writeString(teams_url)
                parcel.writeString(hooks_url)
                parcel.writeString(issue_events_url)
                parcel.writeString(events_url)
                parcel.writeString(assignees_url)
                parcel.writeString(branches_url)
                parcel.writeString(tags_url)
                parcel.writeString(blobs_url)
                parcel.writeString(git_tags_url)
                parcel.writeString(git_refs_url)
                parcel.writeString(trees_url)
                parcel.writeString(statuses_url)
                parcel.writeString(languages_url)
                parcel.writeString(stargazers_url)
                parcel.writeString(contributors_url)
                parcel.writeString(subscribers_url)
                parcel.writeString(subscription_url)
                parcel.writeString(commits_url)
                parcel.writeString(git_commits_url)
                parcel.writeString(comments_url)
                parcel.writeString(issue_comment_url)
                parcel.writeString(contents_url)
                parcel.writeString(compare_url)
                parcel.writeString(merges_url)
                parcel.writeString(archive_url)
                parcel.writeString(downloads_url)
                parcel.writeString(issues_url)
                parcel.writeString(pulls_url)
                parcel.writeString(milestones_url)
                parcel.writeString(notifications_url)
                parcel.writeString(labels_url)
                parcel.writeString(releases_url)
                parcel.writeString(deployments_url)
                parcel.writeString(created_at)
                parcel.writeString(updated_at)
                parcel.writeString(pushed_at)
                parcel.writeString(git_url)
                parcel.writeString(ssh_url)
                parcel.writeString(clone_url)
                parcel.writeString(svn_url)
                parcel.writeString(homepage)
                parcel.writeInt(size)
                parcel.writeInt(stargazers_count)
                parcel.writeInt(watchers_count)
                parcel.writeString(language)
                parcel.writeByte(if (has_issues) 1 else 0)
                parcel.writeByte(if (has_projects) 1 else 0)
                parcel.writeByte(if (has_downloads) 1 else 0)
                parcel.writeByte(if (has_wiki) 1 else 0)
                parcel.writeByte(if (has_pages) 1 else 0)
                parcel.writeInt(forks_count)
                parcel.writeByte(if (archived) 1 else 0)
                parcel.writeInt(open_issues_count)
                parcel.writeInt(forks)
                parcel.writeInt(open_issues)
                parcel.writeInt(watchers)
                parcel.writeString(default_branch)
                parcel.writeDouble(score)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Item> {
                override fun createFromParcel(parcel: Parcel): Item {
                        return Item(parcel)
                }

                override fun newArray(size: Int): Array<Item?> {
                        return arrayOfNulls(size)
                }
        }
}

data class Owner(
        val login: String,
        val id: Int,
        val node_id: String,
        var avatar_url: String,
        val gravatar_id: String,
        val url: String,
        val html_url: String,
        val followers_url: String,
        val following_url: String,
        val gists_url: String,
        val starred_url: String,
        val subscriptions_url: String,
        val organizations_url: String,
        val repos_url: String,
        val events_url: String,
        val received_events_url: String,
        val type: String,
        val site_admin: Boolean
): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString()!!,
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readByte() != 0.toByte()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(login)
                parcel.writeInt(id)
                parcel.writeString(node_id)
                parcel.writeString(avatar_url)
                parcel.writeString(gravatar_id)
                parcel.writeString(url)
                parcel.writeString(html_url)
                parcel.writeString(followers_url)
                parcel.writeString(following_url)
                parcel.writeString(gists_url)
                parcel.writeString(starred_url)
                parcel.writeString(subscriptions_url)
                parcel.writeString(organizations_url)
                parcel.writeString(repos_url)
                parcel.writeString(events_url)
                parcel.writeString(received_events_url)
                parcel.writeString(type)
                parcel.writeByte(if (site_admin) 1 else 0)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Owner> {
                override fun createFromParcel(parcel: Parcel): Owner {
                        return Owner(parcel)
                }

                override fun newArray(size: Int): Array<Owner?> {
                        return arrayOfNulls(size)
                }
        }
}

data class License(
        val key: String,
        val name: String,
        val spdx_id: String,
        val url: String,
        val node_id: String
)