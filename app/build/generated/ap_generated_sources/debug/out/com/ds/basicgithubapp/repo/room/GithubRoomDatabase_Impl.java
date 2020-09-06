package com.ds.basicgithubapp.repo.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GithubRoomDatabase_Impl extends GithubRoomDatabase {
  private volatile GithubDAO _githubDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `github_repo` (`name` TEXT NOT NULL, `full_name` TEXT, `html_url` TEXT, `description` TEXT, `url` TEXT, `team_url` TEXT, `contributors_url` TEXT, `language` TEXT, `avatar_url` TEXT, PRIMARY KEY(`name`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '24304b7e4e47e9404f0da88eed5ec259')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `github_repo`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsGithubRepo = new HashMap<String, TableInfo.Column>(9);
        _columnsGithubRepo.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("full_name", new TableInfo.Column("full_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("html_url", new TableInfo.Column("html_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("team_url", new TableInfo.Column("team_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("contributors_url", new TableInfo.Column("contributors_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("language", new TableInfo.Column("language", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGithubRepo.put("avatar_url", new TableInfo.Column("avatar_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGithubRepo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGithubRepo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGithubRepo = new TableInfo("github_repo", _columnsGithubRepo, _foreignKeysGithubRepo, _indicesGithubRepo);
        final TableInfo _existingGithubRepo = TableInfo.read(_db, "github_repo");
        if (! _infoGithubRepo.equals(_existingGithubRepo)) {
          return new RoomOpenHelper.ValidationResult(false, "github_repo(com.ds.basicgithubapp.repo.room.GithubEntity).\n"
                  + " Expected:\n" + _infoGithubRepo + "\n"
                  + " Found:\n" + _existingGithubRepo);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "24304b7e4e47e9404f0da88eed5ec259", "70c9e50b52f6ec37af59b0e84ac4922f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "github_repo");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `github_repo`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public GithubDAO githubDAO() {
    if (_githubDAO != null) {
      return _githubDAO;
    } else {
      synchronized(this) {
        if(_githubDAO == null) {
          _githubDAO = new GithubDAO_Impl(this);
        }
        return _githubDAO;
      }
    }
  }
}
