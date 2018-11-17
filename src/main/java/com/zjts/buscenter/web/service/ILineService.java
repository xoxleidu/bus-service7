package com.zjts.buscenter.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.web.model.Line;
import com.zjts.buscenter.web.model.Station;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zs
 * @since 2018-11-14
 */
@Service
public interface ILineService extends IService<Line> {
   //插入数据用
   APIResponse insertLine(List<Line> lineList);

   //通过线路名查找 线路信息
   List<JSONObject> findLineBylineName(String lineName);

   //根据跑法号 查询所有站点 以及车辆实时数据绑定
   List<Station>findAllStationAndBus(String runMethod);
}
