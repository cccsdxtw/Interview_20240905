package com.hi.myapplication.ui.exchange;

import com.hi.myapplication.domain.exchange.usecase.CreateNewCurrencyMapUseCase;
import com.hi.myapplication.domain.exchange.usecase.IntegrateResultToMapUseCase;
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
public final class ExchangeRateViewModel_Factory implements Factory<ExchangeRateViewModel> {
  private final Provider<IntegrateResultToMapUseCase> integrateResultToMapUseCaseProvider;

  private final Provider<CreateNewCurrencyMapUseCase> createCurrencyMapProvider;

  public ExchangeRateViewModel_Factory(
      Provider<IntegrateResultToMapUseCase> integrateResultToMapUseCaseProvider,
      Provider<CreateNewCurrencyMapUseCase> createCurrencyMapProvider) {
    this.integrateResultToMapUseCaseProvider = integrateResultToMapUseCaseProvider;
    this.createCurrencyMapProvider = createCurrencyMapProvider;
  }

  @Override
  public ExchangeRateViewModel get() {
    return newInstance(integrateResultToMapUseCaseProvider.get(), createCurrencyMapProvider.get());
  }

  public static ExchangeRateViewModel_Factory create(
      Provider<IntegrateResultToMapUseCase> integrateResultToMapUseCaseProvider,
      Provider<CreateNewCurrencyMapUseCase> createCurrencyMapProvider) {
    return new ExchangeRateViewModel_Factory(integrateResultToMapUseCaseProvider, createCurrencyMapProvider);
  }

  public static ExchangeRateViewModel newInstance(
      IntegrateResultToMapUseCase integrateResultToMapUseCase,
      CreateNewCurrencyMapUseCase createCurrencyMap) {
    return new ExchangeRateViewModel(integrateResultToMapUseCase, createCurrencyMap);
  }
}
