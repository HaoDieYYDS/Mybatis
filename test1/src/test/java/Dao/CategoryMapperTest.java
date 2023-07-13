package Dao;

import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import pojo.Category;
import pojo.Product;
import utils.MybatisUtils;

import java.util.List;

public class CategoryMapperTest extends TestCase {
    CategoryMapper categoryMapper;
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testCategoryMap() {

        SqlSession session = MybatisUtils.getSqlSession();
        categoryMapper = session.getMapper(CategoryMapper.class);
        Category category = categoryMapper.selectById(2);
        System.out.println(category);
        session.close();
    }

    public void testSelectByName() {
        SqlSession session = MybatisUtils.getSqlSession();
        categoryMapper = session.getMapper(CategoryMapper.class);
       Category category =  categoryMapper.selectByName("白色家电");
        System.out.println(category);
        session.close();

    }
}