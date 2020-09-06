package com.ds.basicgithubapp.dagger;

import android.app.Activity;
import com.ds.basicgithubapp.view.GithubActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityModule_ContributeGithubActivity.GithubActivitySubcomponent.class)
public abstract class ActivityModule_ContributeGithubActivity {
  private ActivityModule_ContributeGithubActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(GithubActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      GithubActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface GithubActivitySubcomponent extends AndroidInjector<GithubActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GithubActivity> {}
  }
}
