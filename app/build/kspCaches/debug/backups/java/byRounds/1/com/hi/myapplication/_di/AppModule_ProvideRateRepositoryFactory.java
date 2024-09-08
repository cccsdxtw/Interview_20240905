package com.hi.myapplication._di;

import com.hi.myapplication.data.exchange.RateApiService;
import com.hi.myapplication.data.exchange.RateRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideRateRepositoryFactory implements Factory<RateRepository> {
  private final Provider<RateApiService> apiProvider;

  public AppModule_ProvideRateRepositoryFactory(Provider<RateApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public RateRepository get() {
    return provideRateRepository(apiProvider.get());
  }

  public static AppModule_ProvideRateRepositoryFactory create(
      Provider<RateApiService> apiProvider) {
    return new AppModule_ProvideRateRepositoryFactory(apiProvider);
  }

  public static RateRepository provideRateRepository(RateApiService api) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRateRepository(api));
  }
}
