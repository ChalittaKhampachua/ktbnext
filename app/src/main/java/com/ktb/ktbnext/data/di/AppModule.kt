package com.ktb.ktbnext.data.di

import com.ktb.ktbnext.domain.di.createDomainModule
import com.ktb.ktbnext.screen.account.di.featureAccountModule
import com.ktb.ktbnext.screen.home.di.featureHomeModule
import com.ktb.ktbnext.screen.scan.di.featureScanModule
import com.ktb.ktbnext.screen.services.di.featureServicesModule
import com.ktb.ktbnext.screen.settings.di.featureSettingsModule

fun createAppModule() = listOf(
    createRepositoryModule(),
    createModelModule(),
    createDomainModule(),
    featureHomeModule(),
    featureAccountModule(),
    featureScanModule(),
    featureServicesModule(),
    featureSettingsModule()
)