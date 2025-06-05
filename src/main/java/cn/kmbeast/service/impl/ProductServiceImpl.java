package cn.kmbeast.service.impl;

import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.mapper.OrdersMapper;
import cn.kmbeast.mapper.ProductMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.ProductQueryDto;
import cn.kmbeast.pojo.dto.update.OrdersDTO;
import cn.kmbeast.pojo.entity.Orders;
import cn.kmbeast.pojo.entity.Product;
import cn.kmbeast.pojo.vo.ProductVO;
import cn.kmbeast.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * product service implementation class
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private OrdersMapper ordersMapper;

    /**
     * add new
     * @param product
     * @return background general encapsulation class
     */
    @Override
    public Result<String> save(Product product) {
        if (!StringUtils.hasText(product.getName())) {
            return ApiResult.error("product name can't be null");
        }
        if (product.getBargain() == null) {
            product.setBargain(false);
        }
        if (product.getOldLevel() == null) {
            product.setOldLevel(9);
        }
        if (product.getInventory() == null) {
            product.setInventory(1);
        }
        product.setCreateTime(LocalDateTime.now());
        product.setUserId(LocalThreadHolder.getUserId());
        productMapper.save(product);
        return ApiResult.success("product successfully added");
    }

    /**
     * update
     * @param product
     * @return background general encapsulation class
     */
    @Override
    public Result<String> update(Product product) {
        productMapper.update(product);
        return ApiResult.success("product successfully updated");
    }

    /**
     * delete
     * @param ids to be deleted
     * @return background general encapsulation class
     */
    @Override
    public Result<String> batchDelete(List<Integer> ids) {
        productMapper.batchDelete(ids);
        return ApiResult.success("product successfully deleted");
    }

    /**
     * query
     * @param productQueryDto query param
     * @return background general encapsulation class
     */
    @Override
    public Result<List<ProductVO>> query(ProductQueryDto productQueryDto) {
        int totalCount = productMapper.queryCount(productQueryDto);
        List<ProductVO> productVOList = productMapper.query(productQueryDto);
        return ApiResult.success(productVOList, totalCount);
    }

    /**
     * 商品下单
     *
     * @param ordersDTO 订单
     * @return Result<String>
     */
    @Override
    public Result<String> buyProduct(OrdersDTO ordersDTO) {
        if (ordersDTO.getProductId() == null) {
            return ApiResult.error("invalid order id");
        }
        ProductQueryDto productQueryDto = new ProductQueryDto();
        productQueryDto.setId(ordersDTO.getProductId());
        List<ProductVO> productVOS = productMapper.query(productQueryDto);
        if (productVOS.isEmpty()) {
            return ApiResult.error("item error");
        }
//        if (ordersDTO.getBuyerId() != null && ordersDTO.getBuyerId().equals(productVO.getUserId())) {
//            return ApiResult.error("you cannot buy your own product");
//        }
        // 有且仅有一条商品信息
        ProductVO productVO = productVOS.get(0);
        // 判断库存情况
        if (productVO.getInventory() <= 0
                || (productVO.getInventory() - ordersDTO.getBuyNumber()) < 0) {
            return ApiResult.error("item out of stock");
        }

        createOrders(ordersDTO, productVO);
        ordersMapper.save(ordersDTO);
        // 扣库存
        Product product = new Product();
        product.setId(productVO.getId());
        product.setInventory(productVO.getInventory() - ordersDTO.getBuyNumber());
        productMapper.update(product);
        return ApiResult.success("order success");
    }

    /**
     * 设置订单所需参数
     *
     * @param orders    订单
     * @param productVO 商品信息
     */
    private void createOrders(Orders orders, ProductVO productVO) {
        orders.setCode(createOrdersCode());
        orders.setUserId(LocalThreadHolder.getUserId());
        orders.setTradeStatus(false); // 初始时，未交易成功
        orders.setBuyPrice(productVO.getPrice());
        orders.setCreateTime(LocalDateTime.now());
    }

    /**
     * 生成订单号
     *
     * @return String
     */
    private String createOrdersCode() {
        // UUID
        //String ordersCode = UUID.randomUUID().toString().toLowerCase();
        // 时间戳
        long timeMillis = System.currentTimeMillis();
        return String.valueOf(timeMillis);
    }
}
