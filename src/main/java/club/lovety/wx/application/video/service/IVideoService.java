package club.lovety.wx.application.video.service;

import club.lovety.wx.application.video.entity.VideoInfo;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/3/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IVideoService extends IService<VideoInfo> {

    public BasePageInfo<VideoInfo> queryBasePageInfo(HttpServletRequest request);
}
