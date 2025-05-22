package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品类别的查询条件类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryQueryDto extends QueryDto {
    /**
     * category name
     */
    private String name;
    /**
     * is in use or not
     */
    private Boolean isUse;
}
