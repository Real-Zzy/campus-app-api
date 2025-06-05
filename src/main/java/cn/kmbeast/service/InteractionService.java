package cn.kmbeast.service;

import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.InteractionQueryDto;
import cn.kmbeast.pojo.entity.Interaction;
import cn.kmbeast.pojo.vo.ProductVO;

import java.util.List;

/**
 * Interaction Service Interface
 */
public interface InteractionService {

    Result<String> save(Interaction interaction);

    Result<String> batchDelete(List<Integer> ids);

    Result<List<Interaction>> query(InteractionQueryDto interactionQueryDto);

    Result<Boolean> saveOperation(Integer productId);

    Result<String> likeProduct(Integer productId);

    Result<List<ProductVO>> queryUser();
}
