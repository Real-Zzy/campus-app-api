package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.InteractionQueryDto;
import cn.kmbeast.pojo.entity.Interaction;
import cn.kmbeast.pojo.vo.ProductVO;
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
     * wishlist
     *
     * @param productId 商品ID
     * @return Result<Boolean> 后台通用返回封装类
     */
    @PostMapping(value = "/likeProduct/{productId}")
    @ResponseBody
    public Result<String> likeProduct(@PathVariable Integer productId) {
        return interactionService.likeProduct(productId);
    }

    /**
     * add to/remove from favorite
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
     * 用户删除自己的浏览记录
     */
    @PostMapping(value = "/batchDeleteView")
    @ResponseBody
    public Result<String> batchDeleteInteraction() {
        return interactionService.batchDeleteInteraction();
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

    /**
     * 记录用户对于商品的浏览行为
     *
     * @param productId 商品ID
     * @return Result<Void> 响应结果
     */
    @PostMapping(value = "/view/{productId}")
    @ResponseBody
    public Result<Void> view(@PathVariable Integer productId) {
        return interactionService.view(productId);
    }

    /**
     * 查询用户自己收藏的商品
     *
     * @return Result<List < Interaction>> 响应结果
     */
    @PostMapping(value = "/queryUser")
    @ResponseBody
    public Result<List<ProductVO>> queryUser() {
        return interactionService.queryUser();
    }

    /**
     * 查询用户自己浏览过的商品
     *
     * @return Result<List < ProductVO>> 响应结果
     */
    @PostMapping(value = "/myView")
    @ResponseBody
    public Result<List<ProductVO>> myView() {
        return interactionService.myView();
    }
}