package club.lovety.wx.application.video.entity;


import club.lovety.wx.base.entity.BaseInfo;

/**
 * Created by 念梓  on 2017/3/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class VideoInfo extends BaseInfo {

    private String content;

    private String ip;

    private String nickName;

    /**
     *所有的定位默认为 wgs84 返回 gps 坐标
     */
    private String actualLatitude;  //真实维度

    private String actualLongitude;  //真实经度

    private String latitude;  //

    private String longitude; //

    private String locationName;  //位置信息名称

    private String locationAddress;  //位置详细的地址信息

    private String fileId;  //上传视频的文件Id

    private String imageUrl;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getActualLatitude() {
        return actualLatitude;
    }

    public void setActualLatitude(String actualLatitude) {
        this.actualLatitude = actualLatitude;
    }

    public String getActualLongitude() {
        return actualLongitude;
    }

    public void setActualLongitude(String actualLongitude) {
        this.actualLongitude = actualLongitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
