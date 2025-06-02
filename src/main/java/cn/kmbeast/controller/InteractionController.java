package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.InteractionQueryDto;
import cn.kmbeast.pojo.entity.Interaction;
import cn.kmbeast.service.InteractionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Interaction Controller
 */
@RestController
@RequestMapping("/interaction")
public class InteractionController {

    @Resource
    private InteractionService interactionService;

    /**
     * 收藏操作 （取消收藏与收藏是一组对立的操作）
     *
     * @param productId 商品ID
     * @return Result<Boolean> 后台通用返回封装类
     */
    @PostMapping(value = "/saveOperation/{productId}")
    @ResponseBody
    public Result<Boolean> saveOperation(@PathVariable Integer productId) {
        return interactionService.saveOperation(productId);
    }

    /**
     * batch delete
     */
    @PostMapping(value = "/batchDelete")
    @ResponseBody
    public Result<String> batchDelete(@RequestBody List<Integer> ids) {
        return interactionService.batchDelete(ids);
    }

    /**
     * query
     *
     * @param interactionQueryDto query param
     * @return Result<List<Interaction>> response result
     */
    @Pager
    @PostMapping(value = "/query")
    @ResponseBody
    public Result<List<Interaction>> query(@RequestBody InteractionQueryDto interactionQueryDto) {
        return interactionService.query(interactionQueryDto);
    }
}