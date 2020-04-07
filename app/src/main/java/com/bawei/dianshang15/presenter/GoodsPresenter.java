package com.bawei.dianshang15.presenter;

import com.bawei.dianshang15.base.BasePresenter;
import com.bawei.dianshang15.contact.IContact;

public class GoodsPresenter extends BasePresenter {
    //方法实现
    public GoodsPresenter(IContact.IView iView) {
        super(iView);
    }
    @Override
    protected String getUrl() {
        return "http://mobile.bwstudent.com/small/commodity/v1/commodityList";
    }
}
