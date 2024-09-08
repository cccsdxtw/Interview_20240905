package com.hi.myapplication._di;

import com.hi.myapplication.domain.exchange.usecase.GetRateResponseUseCase;
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
public final class AppModule_ProvideGetRateResponseUseCaseFactory implements Factory<GetRateResponseUseCase> {
  @Override
  public GetRateResponseUseCase get() {
    return provideGetRateResponseUseCase();
  }

  public static AppModule_ProvideGetRateResponseUseCaseFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GetRateResponseUseCase provideGetRateResponseUseCase() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGetRateResponseUseCase());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideGetRateResponseUseCaseFactory INSTANCE = new AppModule_ProvideGetRateResponseUseCaseFactory();
  }
}
