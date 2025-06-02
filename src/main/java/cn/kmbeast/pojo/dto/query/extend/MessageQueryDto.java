package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * message query dto
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MessageQueryDto extends QueryDto {
    /**
     * user ID
     */
    private Integer userId;
}
