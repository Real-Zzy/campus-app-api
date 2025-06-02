package cn.kmbeast.service.impl;

import cn.kmbeast.mapper.InteractionMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.InteractionQueryDto;
import cn.kmbeast.pojo.entity.Interaction;
import cn.kmbeast.service.InteractionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Interaction Service Impl
 */
@Service
public class InteractionServiceImpl implements InteractionService {

    @Resource
    private InteractionMapper interactionMapper;

    /**
     * create new
     *
     * @param interaction param
     * @return Result<String> result
     */
    @Override
    public Result<String> save(Interaction interaction) {
        interactionMapper.save(interaction);
        return ApiResult.success("Interaction Creation Success");
    }

    /**
     * 删除
     *
     * @param ids ids to be batch delete
     * @return Result<String> result
     */
    @Override
    public Result<String> batchDelete(List<Integer> ids) {
        interactionMapper.batchDelete(ids);
        return ApiResult.success("Interaction Deletion Success");
    }

    /**
     * 查询
     *
     * @param interactionQueryDto query dto
     * @return Result<List<Interaction>> result
     */
    @Override
    public Result<List<Interaction>> query(InteractionQueryDto interactionQueryDto) {
        int totalCount = interactionMapper.queryCount(interactionQueryDto);
        List<Interaction> interactionList = interactionMapper.query(interactionQueryDto);
        return ApiResult.success(interactionList, totalCount);
    }
}