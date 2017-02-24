package club.lovety.wx.base.dao;

import club.lovety.wx.base.entity.BaseSearchInfo;

import java.util.List;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IDao<T> {

    public int save(T t);

    public List<T>  queryList(BaseSearchInfo<T> baseSearchInfo);

    public int queryTotalCount(T t);

    public T view(long uid);
}
