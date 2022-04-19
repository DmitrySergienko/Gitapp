package ru.ds.gitapp.ui.gitusers

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.R
import ru.ds.gitapp.databinding.ProfileContentBinding
import ru.ds.gitapp.model.GitUserEntity
import ru.ds.gitapp.ui.main.ContentActivity

class UserAdapter(listArray: ArrayList<GitUserEntity>, context: Context): RecyclerView.Adapter<UserAdapter.SectorsHolder>() {

    //создаем список элементов
    private val sectorItemList = listArray
    val contextAdapter = context


//хранит ссылки на наши элемнты view
    class SectorsHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = ProfileContentBinding.bind(item)


    fun bind(user: GitUserEntity, context: Context) = with(binding) {

        profileName.text = user.name

        profileContentRoot.setOnClickListener {
            val i = Intent(context, ContentActivity::class.java).apply {
                putExtra("Name", profileName.text.toString())

            }
            context.startActivity(i)
        }
    }
}
//надуваем шаблон и предаем в класс SectorHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectorsHolder {
        val view = LayoutInflater.from(contextAdapter).inflate(R.layout.profile_content,parent,false) //get layoutInflater
        return SectorsHolder(view)

    }

    override fun onBindViewHolder(holder: SectorsHolder, position: Int) {
        holder.bind(sectorItemList[position],contextAdapter)
    }

    override fun getItemCount(): Int {
        return sectorItemList.size
    }

    fun addItemSector(itemSector: GitUserEntity){
        sectorItemList.add(itemSector)
         // показывает адаптеру что данные изменились
    }


}