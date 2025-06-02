package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Interaction
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Interaction {
    /**
     * Interaction ID
     */
    private Integer id;

    /**
     * User ID
     */
    private Integer userId;

    /**
     * Product ID
     */
    private Integer productId;

    /**
     * Interaction type
     */
    private Integer type;

    /**
     * Interaction Time
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
