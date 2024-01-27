package com.aycap.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.aycap.kisileruygulamasimvvm.R
import com.aycap.kisileruygulamasimvvm.data.entity.Persons
import com.aycap.kisileruygulamasimvvm.databinding.FragmentHomePageBinding
import com.aycap.kisileruygulamasimvvm.ui.adapter.PersonsAdapter
import com.aycap.kisileruygulamasimvvm.ui.viewmodel.AddPersonViewModel
import com.aycap.kisileruygulamasimvvm.ui.viewmodel.HomepageViewModel
import com.aycap.kisileruygulamasimvvm.util.transition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var binding:FragmentHomePageBinding
    private lateinit var viewModel:HomepageViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false)
        binding.homepageFragment = this
        binding.homepageToolbarTitle = "Persons"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomePage) // Bu sayfadaki toolbarın action bar olduğu anlamına gelir.

        viewModel.personsList.observe(viewLifecycleOwner)
        {

            val adapter = PersonsAdapter(requireContext(),it,viewModel)
            binding.personsAdapter = adapter

        }


        requireActivity().addMenuProvider(object : MenuProvider{

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomepageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(it:View){
        Navigation.transition(it,R.id.addPersonTransition)

    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.allPerson()

    }
}