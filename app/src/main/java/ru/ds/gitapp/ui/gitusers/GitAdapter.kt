package ru.ds.gitapp.ui.gitusers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.data.remote.GitUserEntity

class GitAdapter(private val itemClickCallback: (GitUserEntity) -> Unit) : RecyclerView.Adapter<GitViewHolder>() {

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

    // для передачи listener создаем его в конструкторе (тоесть мы его перекинем в конструктор как аргумент)
   // var itemClickCallback: (GitUserEntity) -> Unit

    // получаем отдельный элемент
    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickCallback)
    }

    private fun getItem(pos: Int): GitUserEntity = data[pos]

    override fun getItemCount(): Int = data.size
}
