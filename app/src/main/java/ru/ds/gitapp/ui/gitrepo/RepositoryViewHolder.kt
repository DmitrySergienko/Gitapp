package ru.ds.gitapp.ui.gitrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ds.gitapp.databinding.ItemGitUserBinding
import ru.ds.gitapp.domain.GitHubEntity


class RepositoryViewHolder(private val binding: ItemGitUserBinding) :
    RecyclerView.ViewHolder(binding.root) {


    companion object {
        fun create(parent: ViewGroup): RepositoryViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return RepositoryViewHolder(ItemGitUserBinding.inflate(inflater))
        }
    }

    //для открытия другого фрагмента обработку клика необходимо вынести в фрагмент
    //для этого указываем в качестве аргумента Entity, далее идем в адаптер для настройки
    fun bind(item: GitHubEntity, listener: (GitHubEntity) -> Unit) = with(binding) {

        itemGitRepoLogin.text = item.login
        itemGitRepoHtml.text = item.html_url
        avatarImageView.load(item.avatarUrl)

        root.setOnClickListener {
            listener.invoke(item)
        }
    }
}