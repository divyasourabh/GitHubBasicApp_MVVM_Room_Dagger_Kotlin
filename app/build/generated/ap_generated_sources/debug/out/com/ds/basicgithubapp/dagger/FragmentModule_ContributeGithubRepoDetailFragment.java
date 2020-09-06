package com.ds.basicgithubapp.dagger;

import androidx.fragment.app.Fragment;
import com.ds.basicgithubapp.view.GithubRepoDetailFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentModule_ContributeGithubRepoDetailFragment.GithubRepoDetailFragmentSubcomponent.class
)
public abstract class FragmentModule_ContributeGithubRepoDetailFragment {
  private FragmentModule_ContributeGithubRepoDetailFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(GithubRepoDetailFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      GithubRepoDetailFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface GithubRepoDetailFragmentSubcomponent
      extends AndroidInjector<GithubRepoDetailFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GithubRepoDetailFragment> {}
  }
}
