package cn.kmbeast.pojo.vo;

import cn.kmbeast.pojo.entity.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Message VO Class
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageVO extends Message {

    /**
     * username
     */
    private String userName;
    /**
     * user account
     */
    private String userAccount;
    /**
     * user avatar
     */
    private String userAvatar;

}