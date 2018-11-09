package com.zjts.buscenter.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zs
 * @since 2018-11-06
 */
@Repository
public interface GpsInfoMapper extends BaseMapper<GpsInfo> {

    /*@Query(value = "SELECT line_id,longitude,latitude FROM gps_info WHERE date_time in (#{time1},#{time2})AND vehicle_number = #{vehicle_number} ORDER BY date_time LIMIT 1")
    @Results({
            @Result(property = "dateTime",column = "date_time"),
            @Result(property = "dateTime",column = "date_time"),
            @Result(property = "vehicleNumber",column = "vehicle_number")
    })*/
    //List<GpsInfo> getGpsInfo(@Param("dateTime") String time1, @Param("dateTime")String time2, @Param("vehicleNumber")String vehicleNumber);

}

