package com.example.reposearchbystars.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


class RepoItem() : Parcelable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("full_name")
    @Expose
    var fullName: String? = null

    @SerializedName("private")
    @Expose
    var private: Boolean? = null

    @SerializedName("owner")
    @Expose
    var owner: Owner? = null

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("fork")
    @Expose
    var fork: Boolean? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("forks_url")
    @Expose
    var forksUrl: String? = null

    @SerializedName("keys_url")
    @Expose
    var keysUrl: String? = null

    @SerializedName("collaborators_url")
    @Expose
    var collaboratorsUrl: String? = null

    @SerializedName("teams_url")
    @Expose
    var teamsUrl: String? = null

    @SerializedName("hooks_url")
    @Expose
    var hooksUrl: String? = null

    @SerializedName("issue_events_url")
    @Expose
    var issueEventsUrl: String? = null

    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null

    @SerializedName("assignees_url")
    @Expose
    var assigneesUrl: String? = null

    @SerializedName("branches_url")
    @Expose
    var branchesUrl: String? = null

    @SerializedName("tags_url")
    @Expose
    var tagsUrl: String? = null

    @SerializedName("blobs_url")
    @Expose
    var blobsUrl: String? = null

    @SerializedName("git_tags_url")
    @Expose
    var gitTagsUrl: String? = null

    @SerializedName("git_refs_url")
    @Expose
    var gitRefsUrl: String? = null

    @SerializedName("trees_url")
    @Expose
    var treesUrl: String? = null

    @SerializedName("statuses_url")
    @Expose
    var statusesUrl: String? = null

    @SerializedName("languages_url")
    @Expose
    var languagesUrl: String? = null

    @SerializedName("stargazers_url")
    @Expose
    var stargazersUrl: String? = null

    @SerializedName("contributors_url")
    @Expose
    var contributorsUrl: String? = null

    @SerializedName("subscribers_url")
    @Expose
    var subscribersUrl: String? = null

    @SerializedName("subscription_url")
    @Expose
    var subscriptionUrl: String? = null

    @SerializedName("commits_url")
    @Expose
    var commitsUrl: String? = null

    @SerializedName("git_commits_url")
    @Expose
    var gitCommitsUrl: String? = null

    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null

    @SerializedName("issue_comment_url")
    @Expose
    var issueCommentUrl: String? = null

    @SerializedName("contents_url")
    @Expose
    var contentsUrl: String? = null

    @SerializedName("compare_url")
    @Expose
    var compareUrl: String? = null

    @SerializedName("merges_url")
    @Expose
    var mergesUrl: String? = null

    @SerializedName("archive_url")
    @Expose
    var archiveUrl: String? = null

    @SerializedName("downloads_url")
    @Expose
    var downloadsUrl: String? = null

    @SerializedName("issues_url")
    @Expose
    var issuesUrl: String? = null

    @SerializedName("pulls_url")
    @Expose
    var pullsUrl: String? = null

    @SerializedName("milestones_url")
    @Expose
    var milestonesUrl: String? = null

    @SerializedName("notifications_url")
    @Expose
    var notificationsUrl: String? = null

    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String? = null

    @SerializedName("releases_url")
    @Expose
    var releasesUrl: String? = null

    @SerializedName("deployments_url")
    @Expose
    var deploymentsUrl: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

    @SerializedName("pushed_at")
    @Expose
    var pushedAt: String? = null

    @SerializedName("git_url")
    @Expose
    var gitUrl: String? = null

    @SerializedName("ssh_url")
    @Expose
    var sshUrl: String? = null

    @SerializedName("clone_url")
    @Expose
    var cloneUrl: String? = null

    @SerializedName("svn_url")
    @Expose
    var svnUrl: String? = null

    @SerializedName("homepage")
    @Expose
    var homepage: String? = null

    @SerializedName("size")
    @Expose
    var size: Int? = null

    @SerializedName("stargazers_count")
    @Expose
    var stargazersCount: Int? = null

    @SerializedName("watchers_count")
    @Expose
    var watchersCount: Int? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("has_issues")
    @Expose
    var hasIssues: Boolean? = null

    @SerializedName("has_projects")
    @Expose
    var hasProjects: Boolean? = null

    @SerializedName("has_downloads")
    @Expose
    var hasDownloads: Boolean? = null

    @SerializedName("has_wiki")
    @Expose
    var hasWiki: Boolean? = null

    @SerializedName("has_pages")
    @Expose
    var hasPages: Boolean? = null

    @SerializedName("forks_count")
    @Expose
    var forksCount: Int? = null

    @SerializedName("mirror_url")
    @Expose
    var mirrorUrl: String? = null

    @SerializedName("archived")
    @Expose
    var archived: Boolean? = null

    @SerializedName("disabled")
    @Expose
    var disabled: Boolean? = null

    @SerializedName("open_issues_count")
    @Expose
    var openIssuesCount: Int? = null

    @SerializedName("license")
    @Expose
    var license: License? = null

    @SerializedName("allow_forking")
    @Expose
    var allowForking: Boolean? = null

    @SerializedName("is_template")
    @Expose
    var isTemplate: Boolean? = null

    @SerializedName("topics")
    @Expose
    var topics: List<String>? = null

    @SerializedName("visibility")
    @Expose
    var visibility: String? = null

    @SerializedName("forks")
    @Expose
    var forks: Int? = null

    @SerializedName("open_issues")
    @Expose
    var openIssues: Int? = null

    @SerializedName("watchers")
    @Expose
    var watchers: Int? = null

    @SerializedName("default_branch")
    @Expose
    var defaultBranch: String? = null

    @SerializedName("permissions")
    @Expose
    var permissions: Permissions? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        nodeId = parcel.readString()
        name = parcel.readString()
        fullName = parcel.readString()
        private = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        owner = parcel.readValue(Owner::class.java.classLoader) as? Owner
        htmlUrl = parcel.readString()
        description = parcel.readString()
        fork = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        url = parcel.readString()
        forksUrl = parcel.readString()
        keysUrl = parcel.readString()
        collaboratorsUrl = parcel.readString()
        teamsUrl = parcel.readString()
        hooksUrl = parcel.readString()
        issueEventsUrl = parcel.readString()
        eventsUrl = parcel.readString()
        assigneesUrl = parcel.readString()
        branchesUrl = parcel.readString()
        tagsUrl = parcel.readString()
        blobsUrl = parcel.readString()
        gitTagsUrl = parcel.readString()
        gitRefsUrl = parcel.readString()
        treesUrl = parcel.readString()
        statusesUrl = parcel.readString()
        languagesUrl = parcel.readString()
        stargazersUrl = parcel.readString()
        contributorsUrl = parcel.readString()
        subscribersUrl = parcel.readString()
        subscriptionUrl = parcel.readString()
        commitsUrl = parcel.readString()
        gitCommitsUrl = parcel.readString()
        commentsUrl = parcel.readString()
        issueCommentUrl = parcel.readString()
        contentsUrl = parcel.readString()
        compareUrl = parcel.readString()
        mergesUrl = parcel.readString()
        archiveUrl = parcel.readString()
        downloadsUrl = parcel.readString()
        issuesUrl = parcel.readString()
        pullsUrl = parcel.readString()
        milestonesUrl = parcel.readString()
        notificationsUrl = parcel.readString()
        labelsUrl = parcel.readString()
        releasesUrl = parcel.readString()
        deploymentsUrl = parcel.readString()
        createdAt = parcel.readString()
        updatedAt = parcel.readString()
        pushedAt = parcel.readString()
        gitUrl = parcel.readString()
        sshUrl = parcel.readString()
        cloneUrl = parcel.readString()
        svnUrl = parcel.readString()
        homepage = parcel.readString()
        size = parcel.readValue(Int::class.java.classLoader) as? Int
        stargazersCount = parcel.readValue(Int::class.java.classLoader) as? Int
        watchersCount = parcel.readValue(Int::class.java.classLoader) as? Int
        language = parcel.readString()
        hasIssues = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        hasProjects = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        hasDownloads = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        hasWiki = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        hasPages = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        forksCount = parcel.readValue(Int::class.java.classLoader) as? Int
        mirrorUrl = parcel.readString()
        archived = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        disabled = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        openIssuesCount = parcel.readValue(Int::class.java.classLoader) as? Int
        allowForking = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isTemplate = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        topics = parcel.createStringArrayList()
        visibility = parcel.readString()
        forks = parcel.readValue(Int::class.java.classLoader) as? Int
        openIssues = parcel.readValue(Int::class.java.classLoader) as? Int
        watchers = parcel.readValue(Int::class.java.classLoader) as? Int
        defaultBranch = parcel.readString()
        permissions = parcel.readValue(Permissions::class.java.classLoader) as? Permissions
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nodeId)
        parcel.writeString(name)
        parcel.writeString(fullName)
        parcel.writeValue(private)
        parcel.writeValue(owner)
        parcel.writeString(htmlUrl)
        parcel.writeString(description)
        parcel.writeValue(fork)
        parcel.writeString(url)
        parcel.writeString(forksUrl)
        parcel.writeString(keysUrl)
        parcel.writeString(collaboratorsUrl)
        parcel.writeString(teamsUrl)
        parcel.writeString(hooksUrl)
        parcel.writeString(issueEventsUrl)
        parcel.writeString(eventsUrl)
        parcel.writeString(assigneesUrl)
        parcel.writeString(branchesUrl)
        parcel.writeString(tagsUrl)
        parcel.writeString(blobsUrl)
        parcel.writeString(gitTagsUrl)
        parcel.writeString(gitRefsUrl)
        parcel.writeString(treesUrl)
        parcel.writeString(statusesUrl)
        parcel.writeString(languagesUrl)
        parcel.writeString(stargazersUrl)
        parcel.writeString(contributorsUrl)
        parcel.writeString(subscribersUrl)
        parcel.writeString(subscriptionUrl)
        parcel.writeString(commitsUrl)
        parcel.writeString(gitCommitsUrl)
        parcel.writeString(commentsUrl)
        parcel.writeString(issueCommentUrl)
        parcel.writeString(contentsUrl)
        parcel.writeString(compareUrl)
        parcel.writeString(mergesUrl)
        parcel.writeString(archiveUrl)
        parcel.writeString(downloadsUrl)
        parcel.writeString(issuesUrl)
        parcel.writeString(pullsUrl)
        parcel.writeString(milestonesUrl)
        parcel.writeString(notificationsUrl)
        parcel.writeString(labelsUrl)
        parcel.writeString(releasesUrl)
        parcel.writeString(deploymentsUrl)
        parcel.writeString(createdAt)
        parcel.writeString(updatedAt)
        parcel.writeString(pushedAt)
        parcel.writeString(gitUrl)
        parcel.writeString(sshUrl)
        parcel.writeString(cloneUrl)
        parcel.writeString(svnUrl)
        parcel.writeString(homepage)
        parcel.writeValue(size)
        parcel.writeValue(stargazersCount)
        parcel.writeValue(watchersCount)
        parcel.writeString(language)
        parcel.writeValue(hasIssues)
        parcel.writeValue(hasProjects)
        parcel.writeValue(hasDownloads)
        parcel.writeValue(hasWiki)
        parcel.writeValue(hasPages)
        parcel.writeValue(forksCount)
        parcel.writeString(mirrorUrl)
        parcel.writeValue(archived)
        parcel.writeValue(disabled)
        parcel.writeValue(openIssuesCount)
        parcel.writeValue(allowForking)
        parcel.writeValue(isTemplate)
        parcel.writeStringList(topics)
        parcel.writeString(visibility)
        parcel.writeValue(forks)
        parcel.writeValue(openIssues)
        parcel.writeValue(watchers)
        parcel.writeString(defaultBranch)
        parcel.writeValue(permissions)
    }

    companion object CREATOR : Parcelable.Creator<RepoItem> {
        override fun createFromParcel(parcel: Parcel): RepoItem {
            return RepoItem(parcel)
        }

        override fun newArray(size: Int): Array<RepoItem?> {
            return arrayOfNulls(size)
        }
    }
}