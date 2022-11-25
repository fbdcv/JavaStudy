package top.fbdcv.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.fbdcv.pojo.Student;
import top.fbdcv.utils.MybatisUtils;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void getStudentList(){
        try (SqlSession sqlSession=MybatisUtils.getSession()){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.getStudentList();
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    @Test
    public void getStudentList2(){
        try (SqlSession sqlSession=MybatisUtils.getSession()){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.getStudentList2();
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}
