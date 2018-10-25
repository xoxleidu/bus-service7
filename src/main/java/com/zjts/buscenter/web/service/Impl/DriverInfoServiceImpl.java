package com.zjts.buscenter.web.service.Impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zjts.buscenter.web.dao.DriverInfoMapper;
import com.zjts.buscenter.web.model.DriverInfo;
import com.zjts.buscenter.web.service.IDriverInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 驾驶员的基本信息表 服务实现类
 * </p>
 *
 * @author han zq
 * @since 2018-10-24
 */

@Service
public class DriverInfoServiceImpl extends ServiceImpl<DriverInfoMapper, DriverInfo> implements IDriverInfoService {
	
}
