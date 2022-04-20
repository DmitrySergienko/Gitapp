package ru.ds.gitapp.ui.gitusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.databinding.ItemGitUserBinding
import ru.ds.gitapp.model.GitUserEntity


class GitViewHolder(private val binding: ItemGitUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): GitViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return GitViewHolder(ItemGitUserBinding.inflate(inflater))
        }
    }

    fun bind(item: GitUserEntity) {
        binding.itemGitRepoEmail.text = item.email
        binding.itemGitRepoName.text = item.name
    }
}