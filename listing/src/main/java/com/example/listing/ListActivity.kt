package com.example.listing

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.DaggerCommonAppComponent
import com.example.common.util.Constants
import com.example.detailsmodule.DetailsActivity
import com.example.listing.di.DaggerListComponent
import com.example.listing.ui.adapter.UniversityAdapter

import com.example.listing.viewmodel.UniversityListViewModel
import javax.inject.Inject

class ListActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: UniversityListViewModel
    private lateinit var adapter: UniversityAdapter

    private lateinit var loader: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        //loader = findViewById(R.id.topLoader)

        DaggerListComponent.builder()
            .commonAppComponent(DaggerCommonAppComponent.create())
//            .listModule(ListModule())
            .build()
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[UniversityListViewModel::class.java]
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        //val headingTextView: TextView = findViewById(R.id.headingTextView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UniversityAdapter(emptyList()) { university ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("UNIVERSITY_NAME", university.name)
            startActivityForResult(intent, Constants.REQUEST_DETAILS)
        }
        recyclerView.adapter = adapter

//        viewModel.loadingState.observe(this, Observer { isLoading ->
//            if (isLoading) {
//                loader.visibility = View.VISIBLE
//            } else {
//                loader.visibility = View.GONE
//            }
//        })

        viewModel.universities.observe(this, Observer { universities ->
            if (universities != null) {
                adapter.updateData(universities)
            }
        })

        viewModel.fetchUniversities(true)
    }

    // Handle the result when DetailsActivity finishes
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.REQUEST_DETAILS && resultCode == RESULT_OK) {
            // Refresh data
            viewModel.fetchUniversities(true)
        }
    }

}