package cn.lawliex.mvp.profile;

import android.content.Intent;
import android.os.AsyncTask;

import cn.lawliex.mvp.model.UserInfo;

/**
 * Created by Terence on 2017/1/1.
 */

public class UserInfoPresenter implements UserInfoContract.Presenter {
    UserInfoContract.View view;
    UserInfo info;

    public UserInfo getNetworkData(){
        //模拟网络io等操作，获取数据
        if(info == null){
            info = new UserInfo();
            info.setAge(16);
            info.setId(1);
            info.setName("lawliex");
        }
        return info;
    }

    public UserInfoPresenter(UserInfoContract.View view) {
        this.view = view;
        view.setPresenter(this);
        start();
    }



    @Override
    public void loadUserInfo() {

        UserInfo userInfo = getNetworkData();

        //取得数据后，因为presenter持有view的引用，可以回调view的相关方法，此处假设加载数据成功，回调显示正常界面
        view.showUserInfoView(userInfo);
        //如果发生错误则回调
        //view.showErrorMessage("error");
    }

    @Override
    public void changeAge() {
        info = view.getUserInfo();
        //模拟更新数据到服务器，成功后，更新View的数据
        start();
    }

    @Override
    public void start() {
        loadUserInfo();
    }
}
