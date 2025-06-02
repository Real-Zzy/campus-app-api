package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Message
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    /**
     * ID
     */
    private Integer id;

    /**
     * User ID
     */
    private Integer userId;

    /**
     * Message Content
     */
    private String content;

    /**
     * Is read or not
     */
    private Boolean isRead;

    /**
     * Sending time
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
