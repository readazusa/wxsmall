package club.lovety.wx.tucao.service.impl;

import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.tucao.entity.TuCaoInfo;
import club.lovety.wx.tucao.service.ITuCaoService;
import org.springframework.stereotype.Service;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class TuCaoServiceImpl implements ITuCaoService {

    @Override
    public int save(TuCaoInfo tuCaoInfo) {
        return 0;
    }

    @Override
    public BasePageInfo<TuCaoInfo> queryBasePageInfo(BaseSearchInfo<TuCaoInfo> baseSearchInfo) {
        return null;
    }
}
