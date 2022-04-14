package com.devil.seata.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("stock_tbl")
public class Stock {
    
    private Long id;
    
    private String commodityCode;
    
    private Long count;
    
}
