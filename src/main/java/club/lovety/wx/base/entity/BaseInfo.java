package club.lovety.wx.base.entity;

import java.util.Date;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class BaseInfo {

    private long uid;   //表的主键ID 通过雪花算法创建为了后续分布式数据库的需要

    private Date createTime;

    private Date updateTime;

    private int flag;  //表示  0:正常,1:删除  2:禁用

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
