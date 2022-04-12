package com.devil.seata.stock.controller;

import com.devil.seata.stock.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("stock")
public class StockController {

    @Resource
    private StockService stockService;

    /**
     * 减库存
     *
     * @param commodityCode 商品代码
     * @param count         数量
     * @return
     */
    @RequestMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        stockService.deduct(commodityCode, count);
        return true;
    }

}
