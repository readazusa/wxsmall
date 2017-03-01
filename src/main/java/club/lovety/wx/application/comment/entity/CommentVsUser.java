package club.lovety.wx.application.comment.entity;

import club.lovety.wx.base.entity.BaseInfo;

/**
 * Created by 念梓  on 2017/3/1.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class CommentVsUser extends BaseInfo {

    public String nickName;

    public long commentId;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
}
