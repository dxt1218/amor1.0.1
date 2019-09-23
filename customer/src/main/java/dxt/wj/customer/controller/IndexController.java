package dxt.wj.customer.controller;

import dxt.wj.customer.constant.WebConst;
import dxt.wj.customer.models.dto.DateParam;
import dxt.wj.customer.models.po.CustomerBasic;
import dxt.wj.customer.service.imp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 首页控制
 * */
@Controller
public class IndexController {

    @Autowired
    CustomerServiceImp customerService;
    /**
     * 首页
     * */
    @GetMapping("/")
    public String index(){
        return WebConst.INDEX_URL;
    }
    /**
     * 注册
     * */
    @PostMapping("/register")
    public String register(){
        return "";
    }


    /**
     * 纪念日首页
     * */
    @GetMapping("/bb")
    public String indexMemorial(Model model){
        CustomerBasic customerBasic = customerService.getById("0000");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateParam dateParam = new DateParam();

        Date nowDate =new Date();
        Date memDate = new Date("2018 12-21");
        dateParam.setNowDate(sdf.format(nowDate));
        dateParam.setStartDate(sdf.format(memDate));
        Calendar nowCalendar = Calendar.getInstance();

        Calendar  mem= Calendar.getInstance();
        mem.setTime(memDate);
        if(nowCalendar.get(Calendar.YEAR)==mem.get(Calendar.YEAR)){
            int  sameYear =  nowCalendar.get(Calendar.DAY_OF_YEAR)-mem.get(Calendar.DAY_OF_YEAR);
            dateParam.setDay(sameYear);
        }else {
            int chaYear =nowCalendar.get(Calendar.YEAR)- mem.get(Calendar.YEAR);
            int day=mem.getActualMaximum(Calendar.DAY_OF_YEAR)-mem.get(Calendar.DAY_OF_YEAR);
            for(int i =1;i<=chaYear;i++){
                if(i==chaYear){
                    day+=nowCalendar.get(Calendar.DAY_OF_YEAR);
                }else {
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.YEAR, mem.get(Calendar.YEAR)+i);
                    day+=cal.getActualMaximum(Calendar.DAY_OF_YEAR);
                }
            }
            dateParam.setDay(day);
        }
        model.addAttribute("dateParam",dateParam);
        return WebConst.MEMORIAL_URL;
    }
}
