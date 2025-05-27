package cn.kmbeast.service.impl;

import cn.kmbeast.mapper.CategoryMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.CategoryQueryDto;
import cn.kmbeast.pojo.dto.query.extend.UserQueryDto;
import cn.kmbeast.pojo.entity.Category;
import cn.kmbeast.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * category service implementation class
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * add new
     * @param category
     * @return background general encapsulation class
     */
    @Override
    public Result<String> save(Category category) {
        if (!StringUtils.hasText(category.getName())) {
            return ApiResult.error("category name can't be null");
        }
        if (category.getIsUse() == null) {
            category.setIsUse(false);
        }
        categoryMapper.save(category);
        return ApiResult.success("category successfully added");
    }

    /**
     * update
     * @param category
     * @return background general encapsulation class
     */
    @Override
    public Result<String> update(Category category) {
        categoryMapper.update(category);
        return ApiResult.success("category successfully updated");
    }

    /**
     * delete
     * @param ids to be deleted
     * @return background general encapsulation class
     */
    @Override
    public Result<String> batchDelete(List<Integer> ids) {
        categoryMapper.batchDelete(ids);
        return ApiResult.success("category successfully deleted");
    }

    /**
     * query
     * @param categoryQueryDto query param
     * @return background general encapsulation class
     */
    @Override
    public Result<List<Category>> query(CategoryQueryDto categoryQueryDto) {
        int totalCount = categoryMapper.queryCount(categoryQueryDto);
        List<Category> categoryList = categoryMapper.query(categoryQueryDto);
        return ApiResult.success(categoryList, totalCount);
    }
}
