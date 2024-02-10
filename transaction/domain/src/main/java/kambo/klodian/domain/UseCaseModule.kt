package kambo.klodian.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    internal fun provideGetTransactionsUseCase(remoteTransactionDataSource: RemoteTransactionDataSource): GetTransactionsUseCase =
        GetTransactionsUseCaseImpl(remoteTransactionDataSource)

    @Provides
    internal fun provideGetTransactionDetailUseCase(remoteTransactionDataSource: RemoteTransactionDataSource): GetTransactionDetailUseCase =
        GetTransactionDetailUseCaseImpl(remoteTransactionDataSource)
}