package com.hi.myapplication.domain.exchange.usecase;

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
public final class IntegrateResultToMapUseCase_Factory implements Factory<IntegrateResultToMapUseCase> {
  private final Provider<FetchCurrencyRateUseCase> fetchCurrencyRateUseCaseProvider;

  private final Provider<GetRateResponseUseCase> getRateResponseUseCaseProvider;

  public IntegrateResultToMapUseCase_Factory(
      Provider<FetchCurrencyRateUseCase> fetchCurrencyRateUseCaseProvider,
      Provider<GetRateResponseUseCase> getRateResponseUseCaseProvider) {
    this.fetchCurrencyRateUseCaseProvider = fetchCurrencyRateUseCaseProvider;
    this.getRateResponseUseCaseProvider = getRateResponseUseCaseProvider;
  }

  @Override
  public IntegrateResultToMapUseCase get() {
    return newInstance(fetchCurrencyRateUseCaseProvider.get(), getRateResponseUseCaseProvider.get());
  }

  public static IntegrateResultToMapUseCase_Factory create(
      Provider<FetchCurrencyRateUseCase> fetchCurrencyRateUseCaseProvider,
      Provider<GetRateResponseUseCase> getRateResponseUseCaseProvider) {
    return new IntegrateResultToMapUseCase_Factory(fetchCurrencyRateUseCaseProvider, getRateResponseUseCaseProvider);
  }

  public static IntegrateResultToMapUseCase newInstance(
      FetchCurrencyRateUseCase fetchCurrencyRateUseCase,
      GetRateResponseUseCase getRateResponseUseCase) {
    return new IntegrateResultToMapUseCase(fetchCurrencyRateUseCase, getRateResponseUseCase);
  }
}
