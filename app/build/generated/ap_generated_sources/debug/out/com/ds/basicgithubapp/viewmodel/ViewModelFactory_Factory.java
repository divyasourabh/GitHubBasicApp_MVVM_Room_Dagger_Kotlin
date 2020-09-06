// Generated by Dagger (https://google.github.io/dagger).
package com.ds.basicgithubapp.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
  private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider;

  public ViewModelFactory_Factory(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
    this.creatorsProvider = creatorsProvider;
  }

  @Override
  public ViewModelFactory get() {
    return provideInstance(creatorsProvider);
  }

  public static ViewModelFactory provideInstance(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
    return new ViewModelFactory(creatorsProvider.get());
  }

  public static ViewModelFactory_Factory create(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
    return new ViewModelFactory_Factory(creatorsProvider);
  }

  public static ViewModelFactory newViewModelFactory(
      Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
    return new ViewModelFactory(creators);
  }
}
