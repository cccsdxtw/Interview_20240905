package com.hi.myapplication.ui.airport;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AirportInfoViewModel_Factory implements Factory<AirportInfoViewModel> {
  @Override
  public AirportInfoViewModel get() {
    return newInstance();
  }

  public static AirportInfoViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AirportInfoViewModel newInstance() {
    return new AirportInfoViewModel();
  }

  private static final class InstanceHolder {
    private static final AirportInfoViewModel_Factory INSTANCE = new AirportInfoViewModel_Factory();
  }
}
