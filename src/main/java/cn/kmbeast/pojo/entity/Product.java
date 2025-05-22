package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Product
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    /**
     * ID
     */
    private Integer id;

    /**
     * Product name
     */
    private String name;

    /**
     * Product description
     */
    private String detail;

    /**
     * Product cover list
     */
    private String coverList;

    /**
     * Product used level
     */
    private Integer oldLevel;

    /**
     * Product category id
     */
    private Integer categoryId;

    /**
     * Product owner id
     */
    private String userId;

    /**
     * Product inventory amount
     */
    private Integer inventory;

    /**
     * Product price
     */
    private BigDecimal price;

    /**
     * bargain or not
     */
    private Boolean bargain;

    /**
     * record time
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
}
