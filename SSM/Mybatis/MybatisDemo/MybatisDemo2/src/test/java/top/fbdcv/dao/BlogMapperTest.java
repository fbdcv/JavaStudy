package top.fbdcv.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.fbdcv.pojo.Blog;
import top.fbdcv.utils.IDUtils;
import top.fbdcv.utils.MybatisUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {

    @Test
    public void addBlogTest(){
        try(SqlSession sqlSession=MybatisUtils.getSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId(IDUtils.getID());
            blog.setTitle("Mybatis");
            blog.setAuthor("狂神说");
            blog.setCreateTime(new Date());
            blog.setViews(9999);

            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setTitle("Java");
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setTitle("Spring");
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setTitle("微服务");
            mapper.addBlog(blog);

        }
    }

    @Test
    public void queryBlogIFTest(){
        try(SqlSession sqlSession=MybatisUtils.getSession()){
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String,Object> map = new HashMap<>() ;
            map.put("title","Java");
            List<Blog> blogs = blogMapper.queryBlogIF(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }

}
