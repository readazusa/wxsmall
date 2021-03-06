package club.lovety.wx.application.comment.entity;

import club.lovety.wx.base.entity.BaseInfo;
import org.apache.commons.lang3.time.DateFormatUtils;

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

    private String avatarUrl;  //头像

    private long parentUid;  //

    private String ip;

    private String dateStr;

    private int commentCount;  //评论的数量

    private int hasLaud; //是否已经评论  0:未评论 ,其他已经评论

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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public long getParentUid() {
        return parentUid;
    }

    public void setParentUid(long parentUid) {
        this.parentUid = parentUid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDateStr() {
        return DateFormatUtils.format(this.getCreateTime(),"MM-dd HH:mm");
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getHasLaud() {
        return hasLaud;
    }

    public void setHasLaud(int hasLaud) {
        this.hasLaud = hasLaud;
    }
}
