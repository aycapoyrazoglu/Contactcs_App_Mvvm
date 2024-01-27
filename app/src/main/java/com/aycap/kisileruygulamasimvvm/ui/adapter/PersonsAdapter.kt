package com.aycap.kisileruygulamasimvvm.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aycap.kisileruygulamasimvvm.R
import com.aycap.kisileruygulamasimvvm.data.entity.Persons
import com.aycap.kisileruygulamasimvvm.databinding.CardDesignBinding
import com.aycap.kisileruygulamasimvvm.databinding.FragmentAddPersonBinding
import com.aycap.kisileruygulamasimvvm.ui.fragment.HomepageFragmentDirections
import com.aycap.kisileruygulamasimvvm.ui.viewmodel.HomepageViewModel
import com.aycap.kisileruygulamasimvvm.util.transition
import com.google.android.material.snackbar.Snackbar

class PersonsAdapter(var mContext:Context,var personsList:List<Persons>,var viewModel: HomepageViewModel) : RecyclerView.Adapter<PersonsAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design:CardDesignBinding) : RecyclerView.ViewHolder(design.root)
    {
        var design:CardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding:CardDesignBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_design,parent,false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personsList.get(position)
        val d = holder.design
        d.personObj = person

        d.cardView.setOnClickListener{
            val transition = HomepageFragmentDirections.personDetailTransition(person=person)
            Navigation.transition(it,transition)
        }
        d.imageViewDelete.setOnClickListener{
            Snackbar.make(it,"Should ${person.person_name} be deleted ?",Snackbar.LENGTH_LONG )
                .setAction("YES"){
                    viewModel.delete(person.person_id)
                }.show()
        }
    }
}