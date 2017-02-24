package club.lovety.wx.base.service;

import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IService<T> {

    public int save(T t);

    public BasePageInfo<T> queryBasePageInfo(BaseSearchInfo<T> baseSearchInfo);


    public T view(long uid);
}
