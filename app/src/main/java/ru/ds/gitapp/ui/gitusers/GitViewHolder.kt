package ru.ds.gitapp.ui.gitusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ds.gitapp.data.remote.GitUserEntity
import ru.ds.gitapp.databinding.ItemGitUserBinding


class GitViewHolder(private val binding: ItemGitUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): GitViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return GitViewHolder(ItemGitUserBinding.inflate(inflater))
        }
    }

    fun bind(item: GitUserEntity) {
        binding.itemGitRepoId.text = item.id
        binding.itemGitRepoName.text = item.name
        binding.imageAvatar.load(item.avatarUrl)

    }
}