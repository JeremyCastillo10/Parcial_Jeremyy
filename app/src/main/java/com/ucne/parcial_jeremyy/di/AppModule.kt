package com.ucne.parcial_jeremyy.di

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.ucne.parcial_jeremyy.data.VerboApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesMoshi():Moshi{
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesVerbosApi(moshi: Moshi):VerboApi{
        return Retrofit.Builder()
            .baseUrl("https://private-a127e-verbos.apiary-mock.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(VerboApi::class.java)
    }

}