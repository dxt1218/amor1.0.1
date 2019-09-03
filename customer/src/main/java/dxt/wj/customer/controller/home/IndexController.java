package dxt.wj.customer.controller.home;

import dxt.wj.customer.constant.WebConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制
 * */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model){
        //model.addAttribute("name","tiantian");
        return WebConst.INDEX_URL;
    }
}
