package com.hi.myapplication._di;

import com.hi.myapplication.domain.exchange.usecase.CreateNewCurrencyMapUseCase;
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
public final class AppModule_ProvideCreateNewCurrencyMapUseCaseFactory implements Factory<CreateNewCurrencyMapUseCase> {
  @Override
  public CreateNewCurrencyMapUseCase get() {
    return provideCreateNewCurrencyMapUseCase();
  }

  public static AppModule_ProvideCreateNewCurrencyMapUseCaseFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CreateNewCurrencyMapUseCase provideCreateNewCurrencyMapUseCase() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCreateNewCurrencyMapUseCase());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideCreateNewCurrencyMapUseCaseFactory INSTANCE = new AppModule_ProvideCreateNewCurrencyMapUseCaseFactory();
  }
}
