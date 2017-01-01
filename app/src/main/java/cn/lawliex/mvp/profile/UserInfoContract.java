package cn.lawliex.mvp.profile;

import cn.lawliex.mvp.BasePresenter;
import cn.lawliex.mvp.BaseView;
import cn.lawliex.mvp.model.UserInfo;

/**
 * Created by Terence on 2017/1/1.
 */

public interface UserInfoContract {

    interface Presenter extends BasePresenter{
        void loadUserInfo();
        void changeAge();
    }
    interface View extends BaseView<Presenter>{
        void showUserInfoView(UserInfo userInfo);
        void showErrorMessage(String errMsg);
        UserInfo getUserInfo();

    }
}
