package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Product Query Data Transfer Object
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductQueryDto extends QueryDto {
    /**
     * category name
     */
    private String name;

    /**
     * Product category id
     */
    private Integer categoryId;

    /**
     * Product owner id
     */
    private Integer userId;

    /**
     * bargain or not
     */
    private Boolean bargain;
}
