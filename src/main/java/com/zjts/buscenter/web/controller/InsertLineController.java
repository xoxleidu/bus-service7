/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-15
 * Time: 10:07
 */
package com.zjts.buscenter.web.controller;

import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.util.LineUtil;
import com.zjts.buscenter.web.model.Line;
import com.zjts.buscenter.web.service.ILineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "插入数据用的",description="ccc")
@RestController
@RequestMapping(value = "/insertLine",produces = "application/json")
public class InsertLineController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(BusInfoController.class);

    @Autowired
    private ILineService lineService;

    @ApiOperation(value = "插入数据用的")
    @PostMapping(value = "/insertLine",produces = "application/json")
    public APIResponse insertLine(@RequestBody @ApiParam(name = "id",value = "车辆id") String mag, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return parameterVerification(bindingResult);
        }
        //String s = "2018-09-19 22:59:57,892 ^LINE||LangFang|1||{1路,1801111136,[{武警学院,116.658518,39.530630},{实验中学,116.664382,39.538911},{看守所,116.664163,39.541803},{颐和佳苑小区,116.663888,39.544470},{华夏奥韵,116.664095,39.545792},{翟各庄,116.671155,39.546660},{丹凤公园爱德堡医院,116.675748,39.547024},{汽配城,116.684494,39.547764},{特教学校西,116.687342,39.548001},{南尖塔,116.692123,39.548347},{市国资委,116.696556,39.548773},{市财政局,116.698779,39.547476},{河北工大,116.699282,39.543463},{华腾嘉园小区,116.699684,39.539930},{市委党校,116.700143,39.536457},{人民公园,116.700692,39.531886},{市民政局,116.701124,39.528324},{新华广场,116.701621,39.524428},{万达广场,116.701796,39.521063},{明珠大厦,116.702440,39.517808},{市医院,116.702694,39.515774},{廊坊北站,116.699972,39.514407},{安次区医院(汇源名居),116.688811,39.511931},{第一中学,116.681836,39.512213},{永兴小区,116.678092,39.515781},{永鸿小区,116.677256,39.520199},{石油技术学院,116.674964,39.522042},{师范学院,116.666906,39.521415},{炮兵学院,116.662402,39.521022},{西昌路花卉市场,116.658940,39.523621},{武警学院,116.658035,39.530957},{西昌路花卉市场,116.658576,39.524381},{炮兵学院,116.663146,39.520978},{师范学院,116.668515,39.521381},{石油技术学院,116.673799,39.521936},{永鸿小区,116.676983,39.520553},{永兴小区,116.677748,39.516348},{第一中学,116.681978,39.511991},{安次区医院(汇源名居),116.688672,39.511768},{廊坊北站,116.699525,39.514325},{市医院,116.702952,39.515885},{明珠大厦,116.702690,39.518436},{万达广场,116.701827,39.520595},{新华广场,116.701918,39.524320},{市民政局,116.701379,39.527198},{人民公园,116.701119,39.530797},{市委党校,116.700605,39.535279},{华腾嘉园小区,116.700047,39.539261},{河北工大,116.699589,39.543025},{市财政局,116.699192,39.546342},{市国资委,116.697050,39.548971},{南尖塔,116.691922,39.548547},{特教学校西,116.687665,39.548187},{汽配城,116.684301,39.547899},{丹凤公园爱德堡医院,116.675550,39.547138},{翟各庄,116.670612,39.546727},{华夏奥韵,116.665205,39.546297},{颐和佳苑小区,116.663523,39.545129},{看守所,116.663959,39.542225},{实验中学,116.664232,39.539423}],[{11,1路,[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,0],[]},{12,1路,[],[30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,30]}],[05:00,23:30,05:00,23:30]}$";
        try{
            List<Line> lineList = LineUtil.run(mag);
            APIResponse zs = lineService.insertLine(lineList);
            System.err.println("======="+zs+"========");
            return zs;
        }catch (Exception e){
            logger.error("出现异常 : "+e.getMessage());
            e.printStackTrace();
            return APIResponse.error(CodeEnum.SAVE_ERROR);
        }
    }
}
