// Generated by data binding compiler. Do not edit!
package com.ds.basicgithubapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ds.basicgithubapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentGithubRepoListBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView recyclerview;

  protected FragmentGithubRepoListBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ProgressBar progressbar, RecyclerView recyclerview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressbar = progressbar;
    this.recyclerview = recyclerview;
  }

  @NonNull
  public static FragmentGithubRepoListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_github_repo_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentGithubRepoListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentGithubRepoListBinding>inflateInternal(inflater, R.layout.fragment_github_repo_list, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentGithubRepoListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_github_repo_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentGithubRepoListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentGithubRepoListBinding>inflateInternal(inflater, R.layout.fragment_github_repo_list, null, false, component);
  }

  public static FragmentGithubRepoListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentGithubRepoListBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentGithubRepoListBinding)bind(component, view, R.layout.fragment_github_repo_list);
  }
}
