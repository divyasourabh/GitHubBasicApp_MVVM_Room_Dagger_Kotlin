package com.ds.basicgithubapp.dagger;

import androidx.fragment.app.Fragment;
import com.ds.basicgithubapp.view.GithubRepoListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentModule_ContributeGithubRepoListFragment.GithubRepoListFragmentSubcomponent.class
)
public abstract class FragmentModule_ContributeGithubRepoListFragment {
  private FragmentModule_ContributeGithubRepoListFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(GithubRepoListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      GithubRepoListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface GithubRepoListFragmentSubcomponent
      extends AndroidInjector<GithubRepoListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GithubRepoListFragment> {}
  }
}
