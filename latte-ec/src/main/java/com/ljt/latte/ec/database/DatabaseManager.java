package com.ljt.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ljt on 2018/3/29.
 */

public class DatabaseManager {

    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DatabaseManager(){}

    private static class Holder{
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public DatabaseManager init(Context context){
        initDao(context);
        return this;
    }

    public static DatabaseManager getInstance(){
        return Holder.INSTANCE;
    }

    private void initDao(Context context){
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getUserProfile(){
        return mDao;
    }

}
