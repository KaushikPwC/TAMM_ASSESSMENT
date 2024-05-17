package com.example.detailsmodule

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.common.DaggerCommonAppComponent
import com.example.common.database.University
import com.example.detailsmodule.di.DaggerDetailsComponent
import com.example.detailsmodule.viewmodel.UniversityDetailsViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.inject.Inject

class DetailsActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UniversityDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
//
        DaggerDetailsComponent.builder()
            .commonAppComponent(DaggerCommonAppComponent.create())
//            .detailsModule(DetailsModule())
            .build()
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[UniversityDetailsViewModel::class.java]

        // Get university name from intent
        val universityName = intent.getStringExtra("UNIVERSITY_NAME") ?: ""

        // Observe LiveData from ViewModel
        viewModel.getUniversityDetails(universityName).observe(this, Observer { university ->
            displayUniversityDetails(university)
        })

        refreshData()
    }

    private fun displayUniversityDetails(university: University) {
        // Example: Update TextViews with university details
        val nameTextView: TextView = findViewById(R.id.textViewUniversityNameValue)
        val locationTextView: TextView = findViewById(R.id.textViewLocationValue)

        nameTextView.text = university.name
        locationTextView.text = university.country
    }

    private fun refreshData() {
        val refreshButton: FloatingActionButton = findViewById(R.id.refreshButton)
        refreshButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}