package cn.lawliex.mvp;

/**
 * Created by Terence on 2017/1/1.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
