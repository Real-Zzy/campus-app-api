package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.MessageQueryDto;
import cn.kmbeast.pojo.vo.MessageVO;
import cn.kmbeast.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * message controller
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * batch delete
     */
    @PostMapping(value = "/batchDelete")
    @ResponseBody
    public Result<String> batchDelete(@RequestBody List<Integer> ids) {
        return messageService.batchDelete(ids);
    }

    /**
     * set viewed
     */
    @PostMapping(value = "/setRead")
    @ResponseBody
    public Result<String> setRead() {
        return messageService.setRead(LocalThreadHolder.getUserId());
    }

    /**
     * query
     *
     * @param messageQueryDto query dto
     * @return Result<List<MessageVO>> response result
     */
    @Pager
    @PostMapping(value = "/query")
    @ResponseBody
    public Result<List<MessageVO>> query(@RequestBody MessageQueryDto messageQueryDto) {
        return messageService.query(messageQueryDto);
    }

    /**
     * query message by user
     *
     * @param messageQueryDto message query dto
     * @return Result<List<MessageVO>> response result
     */
    @PostMapping(value = "/queryUser")
    @ResponseBody
    public Result<List<MessageVO>> queryUser(@RequestBody MessageQueryDto messageQueryDto) {
        messageQueryDto.setUserId(LocalThreadHolder.getUserId());
        return messageService.query(messageQueryDto);
    }
}