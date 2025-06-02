package cn.kmbeast.service.impl;

import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.mapper.InteractionMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.InteractionQueryDto;
import cn.kmbeast.pojo.em.InteractionEnum;
import cn.kmbeast.pojo.entity.Interaction;
import cn.kmbeast.service.InteractionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
     * add to/remove from favorite
     *
     * @param productId item ID
     * @return Result<Boolean> result
     */
    @Override
    public Result<Boolean> saveOperation(Integer productId) {
        InteractionQueryDto interactionQueryDto =
                createInteractionQueryDto(productId, InteractionEnum.SAVE.getType());
        List<Interaction> interactionList = interactionMapper.query(interactionQueryDto);
        if (interactionList.isEmpty()) { // 对应收藏
            Interaction interaction = createInteraction(productId, InteractionEnum.SAVE.getType());
            interactionMapper.save(interaction);
        }else{
            // 对应取消收藏
            List<Integer> interactionIds = interactionList.stream().map(Interaction::getId)
                    .collect(Collectors.toList());
            interactionMapper.batchDelete(interactionIds);
        }
        return ApiResult.success(interactionList.isEmpty() ? "add to favorite success" : "remove from favorite success",interactionList.isEmpty());
    }

    /**
     * create interaction query dto
     *
     * @param productId item ID
     * @param type      interaction type
     * @return Interaction
     */
    private InteractionQueryDto createInteractionQueryDto(Integer productId, Integer type) {
        InteractionQueryDto queryDto = new InteractionQueryDto();
        queryDto.setUserId(LocalThreadHolder.getUserId());
        queryDto.setType(type);
        queryDto.setProductId(productId);
        return queryDto;
    }

    /**
     * create interaction
     *
     * @param productId item ID
     * @param type      interaction type
     * @return Interaction
     */
    private Interaction createInteraction(Integer productId, Integer type) {
        Interaction interaction = new Interaction();
        interaction.setUserId(LocalThreadHolder.getUserId());
        interaction.setType(type);
        interaction.setProductId(productId);
        interaction.setCreateTime(LocalDateTime.now());
        return interaction;
    }

    /**
     * query
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