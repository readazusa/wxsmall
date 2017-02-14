package club.lovety.wx.application.comment.entity;

import club.lovety.wx.base.entity.BaseInfo;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class CommentInfo extends BaseInfo {

    private long relationUid;

    private int type;  //评价的内容类型 0：宝宝秀，1:吐槽吧

    private int laudCount;  //赞的数量

    private String content;

    private String nickName;

    public long getRelationUid() {
        return relationUid;
    }

    public void setRelationUid(long relationUid) {
        this.relationUid = relationUid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLaudCount() {
        return laudCount;
    }

    public void setLaudCount(int laudCount) {
        this.laudCount = laudCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
