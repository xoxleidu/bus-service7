package com.zjts.buscenter.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.Line;
import com.zjts.buscenter.web.model.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zs
 * @since 2018-11-14
 */
@Repository
public interface LineMapper extends BaseMapper<Line> {

    //插入线路数据
    int insertLine(@Param("line_name") String lineName, @Param("line_version") String lineVersion,
                   @Param("run_method") Integer runMethod, @Param("operationTime") String operationTime,
                   @Param("circle") int circle, @Param("up_list") String upList, @Param("down_list") String downList);
    //插入站点数据
    int insertStation(@Param("site_name") String siteName, @Param("lat") Double lat, @Param("lon") Double lon, @Param("run_method") Integer runMethod);

    //根据线路名查询所有 线路
    List<Line> findLineBylineName(@Param("line_name")String lineName);
    //根据跑法号查询 所有站点
    List<Station> findStationByRunMethod(@Param("run_method")Integer runMethod);
    //根据站点名 模糊查询 全名的站点名
    List<Station> findStationByStatonName(@Param("site_name")String siteName);
    //根据跑法号查询所有线路信息
    List<Line> findLineByRunMethod(@Param("run_method")Integer runMethod);
    //根据线路名,跑法号  查询所有该线路上的所有站点
    List<Station> findStationByLineName(@Param("line_name")String lineName,@Param("run_method") Integer runMethod);
    //根据站点名查找 该站点的线路信息
    List<Line> findLineByStationName(@Param("site_name")String siteName);
    //根据跑法号查询 所有车辆即使数据
    List<GpsInfo> findBusByRunMethod(@Param("nowTime")Long time,@Param("run_method") Integer runMethod);
}