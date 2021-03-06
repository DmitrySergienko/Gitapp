package ru.ds.gitapp.ui.gitusers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.domain.GitHubEntity

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var data: List<GitHubEntity> = emptyList()

    //метод настраивает данные
    fun setData(repos: List<GitHubEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    // передаем данные в наш элемент
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    // получаем отдельный элемент
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int): GitHubEntity = data[pos]

    override fun getItemCount(): Int = data.size
}
