package top.fbdcv.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.fbdcv.pojo.Teacher;
import top.fbdcv.utils.MybatisUtils;

public class TeacherMapperTest {
    @Test
    public void getTeacher(){
        try (SqlSession sqlSession=MybatisUtils.getSession()){
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = teacherMapper.getTeacher(1);
            System.out.println(teacher);
        }
    }
}
