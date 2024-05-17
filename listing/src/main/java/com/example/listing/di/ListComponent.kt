package com.example.listing.di

import com.example.common.CommonAppComponent
import com.example.listing.ListActivity
import dagger.Component

@Component(dependencies = [CommonAppComponent::class], modules = [ListModule::class])
interface ListComponent {
     fun inject(activity: ListActivity)
//     fun viewModelFactory(): ViewModelProvider.Factory
     @Component.Builder
     interface Builder {
          fun commonAppComponent(commonAppComponent: CommonAppComponent): Builder
//          fun listModule(listModule: ListModule): Builder
          fun build(): ListComponent
     }
}
