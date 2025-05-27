package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Orders
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
    /**
     * ID
     */
    private Integer id;

    /**
     * Order code
     */
    private String code;

    /**
     * Order detail
     */
    private String detail;

    /**
     * Product ID
     */
    private String productId;

    /**
     * Price of ordered product
     */
    private BigDecimal buyPrice;

    /**
     * Order Status
     */
    private Boolean orderStatus;


    /**
     * Order time
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;
}
