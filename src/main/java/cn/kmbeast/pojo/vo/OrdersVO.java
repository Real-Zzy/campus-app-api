package cn.kmbeast.pojo.vo;

import cn.kmbeast.pojo.entity.Orders;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Orders VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrdersVO extends Orders {
    /**
     * username
     */
    private String userName;
    /**
     * avatar
     */
    private String userAvatar;
    /**
     * item title
     */
    private String productTitle;
    /**
     * image
     */
    private String productCover;
}
