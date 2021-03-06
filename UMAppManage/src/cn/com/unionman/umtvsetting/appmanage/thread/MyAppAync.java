
package cn.com.unionman.umtvsetting.appmanage.thread;

import java.util.List;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;

import cn.com.unionman.umtvsetting.appmanage.MyApplication;
import cn.com.unionman.umtvsetting.appmanage.util.Util;

public class MyAppAync extends AsyncTask<Integer, Integer, List<ResolveInfo>> {

    // private static final String TAG = "MyAppAync";
    private Context mContext = null;

    // The schedule frame
    public MyAppAync(Context context) {

    }

    public MyAppAync(Context context, boolean showDialog) {
        mContext = context;
    }

    @Override
    protected List<ResolveInfo> doInBackground(Integer... params) {

        List<ResolveInfo> resolveInfos = null;
        if (isCancelled()) {
            return resolveInfos;
        }
        if (params.length > 0) {
            switch (params[0]) {
            // Get all the APP data
                case Util.ALL_APP:
                    resolveInfos = Util.getAllApps(mContext);
                    break;
                case Util.ALL_APP_WITHOUT_SYSTEM_APP:
                	resolveInfos = Util.getAllAppsWithoutSystemApps(mContext);
                default:
                    break;
            }
        }

        if (isCancelled()) {
            return null;
        }

        return resolveInfos;
    }

    @Override
    protected void onPostExecute(final List<ResolveInfo> result) {
        super.onPostExecute(result);
        // write into application
        MyApplication application = (MyApplication) mContext
                .getApplicationContext();
        application.setResolveInfos(result);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

}
