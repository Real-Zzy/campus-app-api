package cn.kmbeast.controller;

import cn.kmbeast.aop.Log;
import cn.kmbeast.aop.Pager;
import cn.kmbeast.aop.Protector;
import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.CategoryQueryDto;
import cn.kmbeast.pojo.dto.query.extend.ProductQueryDto;
import cn.kmbeast.pojo.dto.update.OrdersDTO;
import cn.kmbeast.pojo.entity.Category;
import cn.kmbeast.pojo.entity.Product;
import cn.kmbeast.pojo.vo.ProductVO;
import cn.kmbeast.service.CategoryService;
import cn.kmbeast.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Product Controller
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;


    /**
     * 商品下单
     *
     * @param ordersDTO 参数
     * @return Result<String> 响应结果
     */
    @Log(detail = "商品下单")
    @PostMapping(value = "/buyProduct")
    @ResponseBody
    public Result<String> buyProduct(@RequestBody OrdersDTO ordersDTO) {
        return productService.buyProduct(ordersDTO);
    }

    /**
     * add new item
     *
     * @param product
     * @return Result<String> response result
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public Result<String> save(@RequestBody Product product) {
        return productService.save(product);
    }


    /**
     * update item
     *
     * @param product
     * @return Result<String> response result
     */
    @PutMapping(value = "/update")
    @ResponseBody
    public Result<String> update(@RequestBody Product product) {
        return productService.update(product);
    }


    /**
     * delete item
     */
    @PostMapping(value = "/batchDelete")
    @ResponseBody
    public Result<String> batchDelete(@RequestBody List<Integer> ids) {
        return productService.batchDelete(ids);
    }

    /**
     * query item
     *
     * @param productQueryDto
     * @return Result<List<ProductVO>> response result
     */
    @Pager
    @PostMapping(value = "/query")
    @ResponseBody
    public Result<List<ProductVO>> query(@RequestBody ProductQueryDto productQueryDto) {
        return productService.query(productQueryDto);
    }

    /**
     * 商品下单
     *
     * @param ordersId 订单ID
     * @return Result<String> 响应结果
     */
    @PostMapping(value = "/placeAnOrder/{ordersId}")
    @ResponseBody
    public Result<String> placeAnOrder(@PathVariable Integer ordersId) {
        return productService.placeAnOrder(ordersId);
    }

    /**
     * 申请退款
     *
     * @param ordersId 订单ID
     * @return Result<String> 响应结果
     */
    @PostMapping(value = "/refund/{ordersId}")
    @ResponseBody
    public Result<String> refund(@PathVariable Integer ordersId) {
        return productService.refund(ordersId);
    }

    /**
     * query item by user
     *
     * @param productQueryDto query param
     * @return Result<List < ProductVO>> response result
     */
    @PostMapping(value = "/queryUser")
    @ResponseBody
    public Result<List<ProductVO>> queryUser(@RequestBody ProductQueryDto productQueryDto) {
        productQueryDto.setUserId(LocalThreadHolder.getUserId());
        return productService.query(productQueryDto);
    }
}
