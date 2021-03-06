package cn.com.unionman.umtvsetting.picture.logic;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;

import cn.com.unionman.umtvsetting.picture.interfaces.InterfaceValueMaps;
import cn.com.unionman.umtvsetting.picture.interfaces.PictureInterface;
import cn.com.unionman.umtvsetting.picture.logic.factory.InterfaceLogic;
import cn.com.unionman.umtvsetting.picture.model.WidgetType;
import cn.com.unionman.umtvsetting.picture.model.WidgetType.AccessSysValueInterface;
import cn.com.unionman.umtvsetting.picture.util.Constant;
import cn.com.unionman.umtvsetting.picture.util.Util;

import cn.com.unionman.umtvsetting.picture.R;

/**
 * SR
 *
 * @author wangchuanjian
 *
 */
public class SRDemoLogic implements InterfaceLogic {

    private Context mContext;

    // private WidgetType mDemoSR;// support SR
    // private List<WidgetType> mWidgetList = null;
    // private int[][] mDemoSRValue = InterfaceValueMaps.demo_SR;

    public SRDemoLogic(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public List<WidgetType> getWidgetTypeList() {
        List<WidgetType> mWidgetList = new ArrayList<WidgetType>();
        Resources res = mContext.getResources();

        // SR
        WidgetType mDemoSR = new WidgetType();
        // set name for SR
        mDemoSR.setName(res.getStringArray(R.array.demo_mode_setting)[2]);
        // set type for SR
        mDemoSR.setType(WidgetType.TYPE_SELECTOR);
        mDemoSR.setmAccessSysValueInterface(new AccessSysValueInterface() {

            @Override
            public int setSysValue(int i) {
                if (Constant.LOG_TAG) {
                    Log.d("SRlogic", "set current SR mode :" + i);
                }
                return PictureInterface.setSRLevel(i);
            }

            @Override
            public int getSysValue() {
                int res = PictureInterface.getSRLevel();
                if (Constant.LOG_TAG) {
                    Log.d("SRlogic", "get current SR mode :" + res);
                }
                return res;
            }
        });
        // set data for SR
        mDemoSR.setData(Util
                .createArrayOfParameters(InterfaceValueMaps.demo_SR));
        mWidgetList.add(mDemoSR);
        return mWidgetList;
    }

    @Override
    public void setHandler(Handler handler) {
        // TODO Auto-generated method stub

    }
    private static final String TAG = "PictureModeLogic";
    public boolean isHueMode() {
    	// TODO Auto-generated method stub
    	if(TAG.equals("HueModeLogic")){
    		return true;
    	}else{
    		return false;
    	}
    	
    }
}
