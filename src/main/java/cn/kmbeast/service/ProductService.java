package cn.kmbeast.service;

import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.CategoryQueryDto;
import cn.kmbeast.pojo.dto.query.extend.ProductQueryDto;
import cn.kmbeast.pojo.dto.update.OrdersDTO;
import cn.kmbeast.pojo.entity.Category;
import cn.kmbeast.pojo.entity.Product;
import cn.kmbeast.pojo.vo.ProductVO;

import java.util.List;

/**
 * product business logic interface
 */
public interface ProductService {

    Result<String> save(Product product);

    Result<String> update(Product product);

    Result<String> batchDelete(List<Integer> ids);

    Result<List<ProductVO>> query(ProductQueryDto productQueryDto);

    Result<String> buyProduct(OrdersDTO ordersDTO);
}
