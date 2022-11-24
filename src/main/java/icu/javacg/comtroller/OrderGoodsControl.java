package icu.javacg.comtroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import icu.javacg.pojo.OrderGoods;
import icu.javacg.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orderGoods")
public class OrderGoodsControl {

    @Autowired
    OrderGoodsService orderGoodsService;

    @GetMapping("/all")
    public String getOrderGoods(HttpSession session, Model model,@RequestParam("id") Integer id) {
        List<OrderGoods> orderGoodsByUid = orderGoodsService.getOrderGoodsByUid(id);
        model.addAttribute("orderGoodsByUid", orderGoodsByUid);
        return "/html/user/orderGoods/orderGoods";
    }

    @GetMapping("/OrderGoodsQuantity")
    public String addOrder(Integer gid, Integer uid, Model model, Integer addOrSubtract){
        Boolean aBoolean = orderGoodsService.OrderGoodsQuantity(gid, uid, addOrSubtract);
        List<OrderGoods> orderGoodsByUid = orderGoodsService.getOrderGoodsByUid(uid);
        model.addAttribute("orderGoodsByUid", orderGoodsByUid);
        return "/html/user/orderGoods/orderGoods";
    }
}
