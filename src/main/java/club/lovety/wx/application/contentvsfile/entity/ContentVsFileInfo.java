package club.lovety.wx.application.contentvsfile.entity;

import club.lovety.wx.base.entity.BaseInfo;

/**
 * Created by 念梓  on 2017/2/22.
 * Email:sunmch@163.com
 * author: 念梓
 * des:内容和文件关联表
 */
public class ContentVsFileInfo extends BaseInfo {

    private long contentId;

    private long fileId;

    private String type;

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
