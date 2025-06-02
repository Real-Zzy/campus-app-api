package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.InteractionQueryDto;
import cn.kmbeast.pojo.entity.Interaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Interaction Mapper
 */
public interface InteractionMapper {

    /**
     * create interaction
     *
     * @param interaction entity
     * @return int num of modified rows
     */
    int save(Interaction interaction);

    /**
     * query interaction
     *
     * @param interactionQueryDto query dto
     * @return List<Interaction>
     */
    List<Interaction> query(InteractionQueryDto interactionQueryDto);

    /**
     * query interaction count
     *
     * @param interactionQueryDto query dto
     * @return int count
     */
    int queryCount(InteractionQueryDto interactionQueryDto);

    /**
     * batch delete
     *
     * @param ids ids to be batch deleted
     */
    void batchDelete(@Param(value = "ids") List<Integer> ids);

}