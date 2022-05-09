package ru.ds.gitapp.ui.gitusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.databinding.ItemUserFragmentBinding
import ru.ds.gitapp.domain.GitHubEntity


class UserViewHolder(private val binding: ItemUserFragmentBinding) :
    RecyclerView.ViewHolder(binding.root) {


    companion object {
        fun create(parent: ViewGroup): UserViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return UserViewHolder(ItemUserFragmentBinding.inflate(inflater))
        }
    }

    fun bind(item: GitHubEntity) = with(binding) {

        profileName.text = item.name
        profileHtml.text = item.html_url


    }
}