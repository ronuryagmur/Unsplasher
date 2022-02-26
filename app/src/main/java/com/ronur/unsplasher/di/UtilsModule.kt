package com.ronur.unsplasher.di

import android.app.Application
import com.ronur.unsplasher.utils.StringUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    @Singleton
    fun provideStringUtils(app: Application): StringUtils {
        return StringUtils(app)
    }
}