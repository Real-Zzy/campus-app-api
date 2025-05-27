package cn.kmbeast.pojo.vo;

import cn.kmbeast.pojo.entity.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Product Value Object Class
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductVO extends Product {
    /**
     * username
     */
    private String userName;

    /**
     * user avatar
     */
    private String userAvatar;

    /**
     * product category name
     */
    private String categoryName;
}
