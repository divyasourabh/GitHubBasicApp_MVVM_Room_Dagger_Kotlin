package com.ds.basicgithubapp.repo.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GithubDAO_Impl implements GithubDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GithubEntity> __insertionAdapterOfGithubEntity;

  public GithubDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGithubEntity = new EntityInsertionAdapter<GithubEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `github_repo` (`name`,`full_name`,`html_url`,`description`,`url`,`team_url`,`contributors_url`,`language`,`avatar_url`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GithubEntity value) {
        if (value.name == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.name);
        }
        if (value.fullName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.fullName);
        }
        if (value.htmlUrl == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.htmlUrl);
        }
        if (value.description == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.description);
        }
        if (value.url == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.url);
        }
        if (value.teamUrl == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.teamUrl);
        }
        if (value.contributorsUrl == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.contributorsUrl);
        }
        if (value.language == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.language);
        }
        final OwnerEntity _tmpOwnerEntity = value.ownerEntity;
        if(_tmpOwnerEntity != null) {
          if (_tmpOwnerEntity.avatarUrl == null) {
            stmt.bindNull(9);
          } else {
            stmt.bindString(9, _tmpOwnerEntity.avatarUrl);
          }
        } else {
          stmt.bindNull(9);
        }
      }
    };
  }

  @Override
  public void insertGithubRepos(final List<GithubEntity> githubRepoEntityList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGithubEntity.insert(githubRepoEntityList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertGithubRepo(final GithubEntity githubRepoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGithubEntity.insert(githubRepoEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<GithubEntity>> loadGithubRepoList() {
    final String _sql = "SELECT * FROM github_repo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"github_repo"}, false, new Callable<List<GithubEntity>>() {
      @Override
      public List<GithubEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "full_name");
          final int _cursorIndexOfHtmlUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "html_url");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfTeamUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "team_url");
          final int _cursorIndexOfContributorsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "contributors_url");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar_url");
          final List<GithubEntity> _result = new ArrayList<GithubEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GithubEntity _item;
            final OwnerEntity _tmpOwnerEntity;
            if (! (_cursor.isNull(_cursorIndexOfAvatarUrl))) {
              _tmpOwnerEntity = new OwnerEntity();
              _tmpOwnerEntity.avatarUrl = _cursor.getString(_cursorIndexOfAvatarUrl);
            }  else  {
              _tmpOwnerEntity = null;
            }
            _item = new GithubEntity();
            _item.name = _cursor.getString(_cursorIndexOfName);
            _item.fullName = _cursor.getString(_cursorIndexOfFullName);
            _item.htmlUrl = _cursor.getString(_cursorIndexOfHtmlUrl);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.url = _cursor.getString(_cursorIndexOfUrl);
            _item.teamUrl = _cursor.getString(_cursorIndexOfTeamUrl);
            _item.contributorsUrl = _cursor.getString(_cursorIndexOfContributorsUrl);
            _item.language = _cursor.getString(_cursorIndexOfLanguage);
            _item.ownerEntity = _tmpOwnerEntity;
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
