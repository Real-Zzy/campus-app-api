package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.MessageQueryDto;
import cn.kmbeast.pojo.entity.Message;
import cn.kmbeast.pojo.vo.MessageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息持久化接口
 */
public interface MessageMapper {

    /**
     * add
     *
     * @param message entity
     * @return int num modified rows
     */
    int save(Message message);

    /**
     * set to viewed
     *
     * @param userId user ID
     * @return int num rows modified
     */
    int setRead(@Param(value = "userId") Integer userId);

    /**
     * query
     *
     * @param messageQueryDto query DTO
     * @return List<MessageVO>
     */
    List<MessageVO> query(MessageQueryDto messageQueryDto);

    /**
     * query count
     *
     * @param messageQueryDto message query dto
     * @return int num of messages
     */
    int queryCount(MessageQueryDto messageQueryDto);

    /**
     * batch delete
     *
     * @param ids user ids
     */
    void batchDelete(@Param(value = "ids") List<Integer> ids);

}