package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtils {
  private  static SqlSessionFactory sqlSessionFactory;
  static
  {
      Reader reader = null;
      try {
          reader = Resources.getResourceAsReader("mybatis-config.xml");
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      }catch (Exception e)
      {
          e.printStackTrace();
      }
  }
public  static SqlSession getSqlSession()
{
    return sqlSessionFactory.openSession();
}
}
