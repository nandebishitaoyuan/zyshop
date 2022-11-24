package icu.javacg.comtroller;

import icu.javacg.pojo.Commodity;
import icu.javacg.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.resource.HttpResource;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/commodity")
public class CommodityControl {

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/allCommodity")
    public String getAllCommodity(Model model){
        model.addAttribute("commoditys", commodityService.allCommodity());
        return "/html/user/commodity/allCommodity";
    }

    @GetMapping("/info")
    public String getCommodityInfo(Integer id, Model model){
        Commodity commodity = commodityService.getCommodityById(id);
        String gbrief = commodity.getGbrief();
        char[] chars = gbrief.toCharArray();
        if (chars.length > 20){
            char[] temp = new char[20];
            System.arraycopy(chars, 0, temp, 0, 20);
            String s = new String(temp);
            commodity.setGbrief(s);
        }
        model.addAttribute("commodityInfo", commodity);
        return "/html/user/commodity/info";
    }

    @GetMapping("/search")
    public String getSearch(String name, Model model){
        List<Commodity> commodityByName = commodityService.getCommodityByName(name);
        model.addAttribute("commoditys", commodityByName);
        return "/html/user/commodity/allCommodity";
    }

    @GetMapping("/addOrder")
    public String addOrder(Integer uid, Integer gid, Model model){
        commodityService.addOrder(uid,gid);
        Commodity commodity = commodityService.getById(gid);
        String gbrief = commodity.getGbrief();
        char[] chars = gbrief.toCharArray();
        if (chars.length > 20){
            char[] temp = new char[20];
            System.arraycopy(chars, 0, temp, 0, 20);
            String s = new String(temp);
            commodity.setGbrief(s);
        }
        model.addAttribute("commodityInfo", commodity);
        return "/html/user/commodity/info";
    }
}
