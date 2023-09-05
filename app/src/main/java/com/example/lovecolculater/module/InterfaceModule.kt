package com.example.lovecolculater.module

import com.example.lovecolculater.FirstFragment
import com.example.lovecolculater.view.FirstView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class InterfaceModule {
    @Binds
    abstract fun bindLoveView(firstFragment: FirstFragment):FirstView
}