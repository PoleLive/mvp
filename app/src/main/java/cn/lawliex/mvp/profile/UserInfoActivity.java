package cn.lawliex.mvp.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.lawliex.mvp.R;
import cn.lawliex.mvp.model.UserInfo;

public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.View{

    TextView nameTxt;
    TextView ageTxt;
    EditText newAgeEdit;
    Button change;
    UserInfoContract.Presenter presenter;
    UserInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        nameTxt = (TextView)findViewById(R.id.name);
        ageTxt = (TextView)findViewById(R.id.age);
        newAgeEdit = (EditText)findViewById(R.id.new_age);
        change = (Button)findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = newAgeEdit.getText().toString();
                if(str.length() !=0 ){
                    int ageInt = Integer.valueOf(str);
                    info.setAge(ageInt);
                    presenter.changeAge();
                }
            }
        });
        //创建Presenter
        UserInfoContract.Presenter presenter =new UserInfoPresenter(this);
    }

    @Override
    public void showUserInfoView(UserInfo userInfo) {
        //更新用户界面
        info = userInfo;
        nameTxt.setText(userInfo.getName());
        ageTxt.setText(userInfo.getAge() + "");
    }

    @Override
    public void showErrorMessage(String errMsg) {
        //显示错误信息
        Toast.makeText(this,errMsg,Toast.LENGTH_LONG).show();
    }

    @Override
    public UserInfo getUserInfo() {
        return info;
    }

    @Override
    public void setPresenter(UserInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }



}
