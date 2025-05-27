package cn.kmbeast.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * product category
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    /**
     * ID
     */
    private Integer id;

    /**
     * Category Name
     */
    private String name;

    /**
     * In use or not
     */
    private Boolean isUse;
}
