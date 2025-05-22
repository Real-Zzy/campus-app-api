package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.CategoryQueryDto;
import cn.kmbeast.pojo.dto.query.extend.UserQueryDto;
import cn.kmbeast.pojo.entity.Category;
import cn.kmbeast.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * category持久化接口
 */
public interface CategoryMapper {


    /**
     * add new
     *
     * @param category
     * @return int 受影响行数
     */
    int save(Category category);

    /**
     * 分页查询用户信息
     *
     * @param categoryQueryDto 分页查询参数
     * @return List<Category>
     */
    List<Category> query(CategoryQueryDto categoryQueryDto);

    /**
     * 查询满足分页查询的记录总数
     *
     * @param categoryQueryDto 分页查询参数
     * @return int 数据总数
     */
    int queryCount(CategoryQueryDto categoryQueryDto);

    /**
     * update category information
     *
     * @param category category information
     * @return int 受影响行数
     */
    int update(Category category);

    /**
     * batch delete category
     *
     * @param ids 用户ID集合
     */
    void batchDelete(@Param(value = "ids") List<Integer> ids);


}
