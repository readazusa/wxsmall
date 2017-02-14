package club.lovety.wx.application.tucao.service.impl;

import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.IdWorker;
import club.lovety.wx.tucao.dao.ITuCaoDao;
import club.lovety.wx.tucao.entity.TuCaoInfo;
import club.lovety.wx.tucao.service.ITuCaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class TuCaoServiceImpl implements ITuCaoService {

    @Resource
    private ITuCaoDao tuCaoDao;

    @Override
    public int save(TuCaoInfo tuCaoInfo) {
        tuCaoInfo.setUid(IdWorker.instance.getId());
        tuCaoInfo.setCreateTime(new Date());
        tuCaoInfo.setUpdateTime(new Date());
        return tuCaoDao.save(tuCaoInfo);
    }

    @Override
    public BasePageInfo<TuCaoInfo> queryBasePageInfo(BaseSearchInfo<TuCaoInfo> baseSearchInfo) {
        BasePageInfo<TuCaoInfo> basePageInfo = new BasePageInfo<>();
        basePageInfo.setPageIndex(baseSearchInfo.getPageIndex());
        int totalCount = tuCaoDao.queryTotalCount(baseSearchInfo.getT());
        List<TuCaoInfo> tuCaoInfos  = tuCaoDao.queryList(baseSearchInfo);
        basePageInfo.setData(tuCaoInfos);
        basePageInfo.setData(tuCaoInfos);
        return basePageInfo;
    }
}
