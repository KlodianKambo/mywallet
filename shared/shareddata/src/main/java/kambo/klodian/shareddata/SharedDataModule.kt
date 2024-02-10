package kambo.klodian.shareddata

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kambo.klodian.shareddomain.datasource.CacheAppStateDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class SharedDataModule {

    @Provides
    @Singleton
    fun provideCacheAppStateDataSource(impl: CacheAppStateDataSourceImpl): CacheAppStateDataSource =
        impl

}