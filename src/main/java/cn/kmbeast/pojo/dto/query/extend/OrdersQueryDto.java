package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * Order Query Dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrdersQueryDto extends QueryDto {
    /**
     * Order Number
     */
    private String code;
    /**
     * Order Detail
     */
    private String detail;
    /**
     * User ID
     */
    private Integer userId;
    /**
     * Item ID
     */
    private Integer productId;
    /**
     * Order Status
     */
    private Boolean tradeStatus;
    /**
     * Refund Status
     */
    private Boolean refundStatus;
}