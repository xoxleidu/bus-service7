/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-23
 * Time: 15:21
 */
package com.zjts.buscenter.web.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zjts.buscenter.web.dao.BusInfoMapper;
import com.zjts.buscenter.web.model.BusInfo;
import com.zjts.buscenter.web.service.IBusInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公交车
 * 业务层 实现类
 *
 */

@Service
@Transactional
public class BusInfoServiceimpI extends ServiceImpl<BusInfoMapper,BusInfo> implements IBusInfoService {


}
