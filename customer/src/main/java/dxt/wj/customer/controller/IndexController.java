package dxt.wj.customer.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dxt.wj.customer.constant.WebConst;
import dxt.wj.customer.models.dto.DateParam;
import dxt.wj.customer.models.dto.RegisterParam;
import dxt.wj.customer.models.po.CustomerBasic;
import dxt.wj.customer.service.imp.CustomerServiceImp;
import helper.ModelHelper;
import helper.ResHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.ObjJsonUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 首页控制
 * */
@Controller
@Slf4j
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
     * 登录页
     * */
    @GetMapping("/login")
    public String loginHtml(){
        return WebConst.LOGIN_URL;
    }

    /**
     * 注册信息录入
     * */
    @PostMapping("/login/register")
    @ResponseBody
    public ResHelper register(@RequestBody RegisterParam param){
        log.info("入参："+param);
        if(StringUtils.isEmpty(param.getLoginName())){
            return ResHelper.success("1111","登录昵称不能为空");
        }
        CustomerBasic customerBasic =(CustomerBasic)ObjJsonUtil.objToObj(param,CustomerBasic.class);
        ModelHelper.initModel(customerBasic);
        log.info("customerService == "+customerBasic);
        customerService.save(customerBasic);
        return ResHelper.success("0000");
    }
    /**
     * 纪念日
     * */
    @GetMapping("/demo")
    public String memorial(){
        return "home/demo";
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
        Date memDate = new Date("2018 12-21");//纪念日期  可变量
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
