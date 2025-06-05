package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.OrdersQueryDto;
import cn.kmbeast.pojo.entity.Orders;
import cn.kmbeast.pojo.vo.OrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Orders Mapper
 */
public interface OrdersMapper {

    /**
     * add
     *
     * @param orders Order Entity
     * @return int num rows modified
     */
    int save(Orders orders);

    /**
     * query
     *
     * @param ordersQueryDto query dto
     * @return List<OrdersVO>
     */
    List<OrdersVO> query(OrdersQueryDto ordersQueryDto);

    /**
     * query count
     *
     * @param ordersQueryDto query dto
     * @return int count
     */
    int queryCount(OrdersQueryDto ordersQueryDto);

    /**
     * update
     *
     * @param orders order entity
     * @return int num rows changed
     */
    int update(Orders orders);

    /**
     * batch delete
     *
     * @param ids user ids
     */
    void batchDelete(@Param(value = "ids") List<Integer> ids);

    List<OrdersVO> queryByProductIds(OrdersQueryDto ordersQueryDto);

}