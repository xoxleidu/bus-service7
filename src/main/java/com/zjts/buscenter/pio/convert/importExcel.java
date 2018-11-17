/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-13
 * Time: 17:13
 */
package com.zjts.buscenter.pio.convert;

import com.zjts.buscenter.web.dao.BusInfoMapper;
import com.zjts.buscenter.web.model.BusInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class importExcel {

    @Autowired
    private BusInfoMapper busInfoMapper;
    @Test
    public void importexcel(String path){
        //String path ="路径.xlsx";

        XlsMain xlsMain = new XlsMain();
        try {
            List<BusInfo> list = xlsMain.readXls(path);
            for (int i = 0; i < list.size(); i++) {
                busInfoMapper.insert(list.get(i));
                System.err.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
