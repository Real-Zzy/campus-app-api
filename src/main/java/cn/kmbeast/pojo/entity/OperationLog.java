package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Operation Log
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationLog {
    /**
     * ID
     */
    private Integer id;

    /**
     * User ID
     */
    private Integer userId;

    /**
     * Operation description
     */
    private String detail;

    /**
     * record time
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
}
