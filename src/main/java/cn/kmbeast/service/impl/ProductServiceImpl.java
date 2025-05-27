package cn.kmbeast.service.impl;

import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.mapper.ProductMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.ProductQueryDto;
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
}
