package ru.ds.gitapp.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.gitapp.R
import ru.ds.gitapp.databinding.ProfileContentBinding
import ru.ds.gitapp.domain.local.Profile

class ProfileAdapter(listArray: ArrayList<Profile>, context: Context): RecyclerView.Adapter<ProfileAdapter.SectorsHolder>() {

    //создаем список элементов
    private val sectorItemList = listArray
    val contextAdapter = context


//хранит ссылки на наши элемнты view
    class SectorsHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = ProfileContentBinding.bind(item)


    fun bind(profile: Profile, context: Context) = with(binding) {
        profileImageView.setImageResource(profile.idImage)
        profileName.text = profile.name
        profileEmail.text = profile.email

        profileName.text = profile.name

        profileContentRoot.setOnClickListener {
            val i = Intent(context, ContentActivity::class.java).apply {
                putExtra("Name", profileName.text.toString())
                putExtra("email", profileEmail.text.toString())
                putExtra("image", profile.idImage)
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

    fun addItemSector(itemSector: Profile){
        sectorItemList.add(itemSector)
         // показывает адаптеру что данные изменились
    }


}