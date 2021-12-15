package com.practicle.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicle.adapter.FamilyAdapter
import com.practicle.api.ApiHelperImpl
import com.practicle.api.RetrofitBuilder
import com.practicle.databinding.ActivityHomeBinding
import com.practicle.model.FamilyData
import com.practicle.utils.*
import com.practicle.viewmodel.HomeViewModel
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var date: String;
    private var yearSelected: Int? = null
    private var month: Int? = null
    private var day: Int? = null
    private val familyList = arrayListOf<FamilyData>()
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvFamily.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.rvFamily.adapter = FamilyAdapter(familyList)
        val c = Calendar.getInstance()
        yearSelected = c.get(Calendar.YEAR)
        month = c.get(Calendar.MONTH)
        day = c.get(Calendar.DAY_OF_MONTH)

        setupViewModel()
        setupObserver()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService)
            )
        ).get(HomeViewModel::class.java)
    }

    private fun setupObserver() {
        familyList.clear()
        viewModel.getFamily().observe(this@HomeActivity, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE;
                    binding.rvFamily.visibility = View.VISIBLE;

                    familyList.clear()
                    familyList.addAll(it.data!!)
                    binding.rvFamily.adapter?.notifyDataSetChanged();

                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE;
                    binding.rvFamily.visibility = View.GONE;
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE;
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

    }


}