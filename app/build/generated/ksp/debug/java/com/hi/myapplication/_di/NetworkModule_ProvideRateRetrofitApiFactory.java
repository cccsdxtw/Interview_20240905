package com.hi.myapplication._di;

import com.hi.myapplication.data.exchange.RateApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkModule_ProvideRateRetrofitApiFactory implements Factory<RateApiService> {
  @Override
  public RateApiService get() {
    return provideRateRetrofitApi();
  }

  public static NetworkModule_ProvideRateRetrofitApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RateApiService provideRateRetrofitApi() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideRateRetrofitApi());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideRateRetrofitApiFactory INSTANCE = new NetworkModule_ProvideRateRetrofitApiFactory();
  }
}
