package ru.ds.gitapp.ui.about

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.model.GitUserEntity

class GitAdapter : RecyclerView.Adapter<GitViewHolder>() {

    private var data: List<GitUserEntity> = emptyList()

    //метод настраивает данные
    fun setData(repos: List<GitUserEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    // передаем данные в наш элемент
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        return GitViewHolder.create(parent)
    }

    // получаем отдельный элемент
    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int): GitUserEntity = data[pos]

    override fun getItemCount(): Int = data.size
}
