package com.example.detailsmodule.di

import com.example.common.CommonAppComponent
import com.example.detailsmodule.DetailsActivity
import dagger.Component

@Component(dependencies = [CommonAppComponent::class], modules = [DetailsModule::class])
interface DetailsComponent {
     fun inject(activity: DetailsActivity)
//     fun viewModelFactory(): ViewModelProvider.Factory
     @Component.Builder
     interface Builder {
          fun commonAppComponent(commonAppComponent: CommonAppComponent): Builder
//          fun detailsModule(detailsModule: DetailsModule): Builder
          fun build(): DetailsComponent
     }
}
