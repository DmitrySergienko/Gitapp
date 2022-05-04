package ru.ds.gitapp.ui.gitrepo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.domain.GitHubEntity


// настраиваем адаптер для открытия фрагмента
// создаем itemClickCallback в конструкторе (тоесть мы его перекинем в конструктор как аргумент)

class RepositoryAdapter(private val itemClickCallback: (GitHubEntity) -> Unit) : RecyclerView.Adapter<RepositoryViewHolder>() {

    private var data: List<GitHubEntity> = emptyList()

    //метод настраивает данные
    fun setData(repos: List<GitHubEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    // передаем данные в наш элемент
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder.create(parent)
    }

    // получаем отдельный элемент
    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickCallback)
    }

    private fun getItem(pos: Int): GitHubEntity = data[pos]

    override fun getItemCount(): Int = data.size
}
