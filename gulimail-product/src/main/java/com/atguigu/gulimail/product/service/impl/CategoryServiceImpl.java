package com.atguigu.gulimail.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimail.product.dao.CategoryDao;
import com.atguigu.gulimail.product.entity.CategoryEntity;
import com.atguigu.gulimail.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

//    @Autowired  因为集成父类接口 泛型中 已经指定了CategoryDao
     //所有直接可用
//    CategoryDao categoryDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //组装父子的树形结构
        //找到所有的一级分类
        List<CategoryEntity> level1Menu = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0).map((menu)->{
                    menu.setChildren(getChildrens(menu,entities));
                    return menu;
        }).sorted((currentMenu,menu2)->{
            return (currentMenu.getSort() == null ? 0:currentMenu.getSort()) -  (menu2.getSort()== null ?0 : menu2.getSort());
        }).collect(Collectors.toList());
        return level1Menu;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 检查当前删除的菜单，是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }

    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return  categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            // 1.找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort() == null ? 0:menu1.getSort()) -  (menu2.getSort()== null ?0 : menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}