package cn.kmbeast.service.impl;

import cn.kmbeast.mapper.MessageMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.MessageQueryDto;
import cn.kmbeast.pojo.entity.Message;
import cn.kmbeast.pojo.vo.MessageVO;
import cn.kmbeast.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * message service impl
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    /**
     * 新增
     *
     * @param message param
     * @return Result<String> result
     */
    @Override
    public Result<String> save(Message message) {
        messageMapper.save(message);
        return ApiResult.success("message sent");
    }

    /**
     * set message viewed
     *
     * @param userId user ID
     * @return Result<String> result
     */
    @Override
    public Result<String> setRead(Integer userId) {
        messageMapper.setRead(userId);
        return ApiResult.success("message viewed");
    }

    /**
     * delete
     *
     * @param ids ids to be deleted
     * @return Result<String> result
     */
    @Override
    public Result<String> batchDelete(List<Integer> ids) {
        messageMapper.batchDelete(ids);
        return ApiResult.success("message deleted");
    }

    /**
     * 查询
     *
     * @param messageQueryDto query param
     * @return Result<List<MessageVO>> result
     */
    @Override
    public Result<List<MessageVO>> query(MessageQueryDto messageQueryDto) {
        int totalCount = messageMapper.queryCount(messageQueryDto);
        List<MessageVO> messageVOList = messageMapper.query(messageQueryDto);
        return ApiResult.success(messageVOList, totalCount);
    }
}