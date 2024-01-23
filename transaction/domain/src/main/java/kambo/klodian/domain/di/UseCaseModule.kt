package kambo.klodian.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kambo.klodian.domain.GetTransactionsUseCase
import kambo.klodian.domain.GetTransactionsUseCaseImpl
import kambo.klodian.domain.datasource.RemoteTransactionDataSource


@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    internal fun provideGetTransactionsUseCase(remoteTransactionDataSource: RemoteTransactionDataSource): GetTransactionsUseCase =
        GetTransactionsUseCaseImpl(remoteTransactionDataSource)
}