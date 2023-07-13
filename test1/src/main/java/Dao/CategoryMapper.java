package Dao;

import org.apache.ibatis.annotations.Select;
import pojo.Category;
import pojo.Product;

import java.util.List;

public interface CategoryMapper {
    public Category selectById(int id);

    @Select("select * from category where typename = #{typename}")
    public Category selectByName(String typename);
}
