package com.iweb.order.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.iweb.order.Order;
import com.iweb.order.properties.OrderProperties;
import com.iweb.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


@CrossOrigin //跨域注解
//@RequestMapping("/api/order")
@Slf4j
//@RefreshScope//自动刷新
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderProperties orderProperties;

   /* @Value("${order.timeout}")
    String orderTimeout;
    @Value("${order.orderAutoConfirm}")
    String orderAutoConfirm;*/

    /*public String config(){
        return "order.timeout="+orderTimeout+";order.orderAutoConfirm="+orderAutoConfirm;
    }*/

    @GetMapping("/config")
    public String config() {
        return "order.timeout=" + orderProperties.getTimeout() + ";" +
                "order.AutoConfirm=" + orderProperties.getAutoConfirm() + ";" +
                "order.db-url=" + orderProperties.getDbUrl();
    }

    //创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId, @RequestParam("userId") Long userId) {
        Order order = orderService.createOrder(productId, userId);
        return order;
    }

    @GetMapping("/seckill")
    @SentinelResource(value = "seckill-order", fallback = "seckillFallback")
    public Order seckill(@RequestParam(value = "userId", required = false) Long userId, @RequestParam(value = "productId", defaultValue="1000") Long productId) {
        Order order = orderService.createOrder(productId, userId);
        order.setId(Long.MAX_VALUE);
        return order;
    }

    public Order seckillFallback(Long userId, Long productId, BlockException exception) {
        System.out.println("seckillFallback....");
        Order order = new Order();
        order.setId(productId);
        order.setUserId(userId);
        order.setAddress("异常信息：" + exception.getClass());
        return order;
    }
}
