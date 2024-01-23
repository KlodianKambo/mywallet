package kambo.klodian.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kambo.klodian.data.RemoteTransactionDataSourceImpl
import kambo.klodian.domain.datasource.RemoteTransactionDataSource

@Module
@InstallIn(SingletonComponent::class)
class TransactionDataModule {

    @Provides
    fun provideRemoteTransactionDataSource(impl: RemoteTransactionDataSourceImpl): RemoteTransactionDataSource =
        impl
}