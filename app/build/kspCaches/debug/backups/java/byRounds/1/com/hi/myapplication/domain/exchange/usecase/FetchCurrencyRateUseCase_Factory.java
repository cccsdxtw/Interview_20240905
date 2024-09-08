package com.hi.myapplication.domain.exchange.usecase;

import com.hi.myapplication.data.exchange.RateRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class FetchCurrencyRateUseCase_Factory implements Factory<FetchCurrencyRateUseCase> {
  private final Provider<RateRepository> repositoryProvider;

  public FetchCurrencyRateUseCase_Factory(Provider<RateRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public FetchCurrencyRateUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static FetchCurrencyRateUseCase_Factory create(
      Provider<RateRepository> repositoryProvider) {
    return new FetchCurrencyRateUseCase_Factory(repositoryProvider);
  }

  public static FetchCurrencyRateUseCase newInstance(RateRepository repository) {
    return new FetchCurrencyRateUseCase(repository);
  }
}
