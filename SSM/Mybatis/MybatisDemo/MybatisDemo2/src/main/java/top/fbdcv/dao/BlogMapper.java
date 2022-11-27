package top.fbdcv.dao;

import top.fbdcv.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    void addBlog(Blog blog);
    List<Blog> queryBlogIF(Map map);
}
