package com.zjts.buscenter.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zjts.buscenter.web.model.FaultInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zs
 * @since 2018-10-25
 */
public interface FaultInfoMapper extends BaseMapper<FaultInfo> {

    @Select("SELECT bus_basis.* FROM bus_basis,fault_info WHERE fault_info.license_number=bus_basis.license_number")
    List<FaultInfo> findBusBylicenseNumber(Page<FaultInfo> page);
//  List<FaultInfo> findBusBylicenseNumber(PageHelper page);
}