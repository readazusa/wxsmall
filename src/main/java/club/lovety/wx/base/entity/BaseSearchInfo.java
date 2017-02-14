package club.lovety.wx.base.entity;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class BaseSearchInfo<T> {

    private T t;

    private int pageSize = 10;

    private int pageIndex = 1;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
