package net.wanho.test;

import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import util.MybatisUtil;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Jerk on 2019/6/5.
 */
public class TestMybatis {


    private SqlSession sqlSession;
    private StudentMapper studentMapper;
    @Before
    public void before(){
       /* InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession=sf.openSession();*/
       sqlSession=MybatisUtil.getSession();
       studentMapper=sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void testAddStu() {
        Student student=new Student(null,"zhangsan",21,"男","南京");
        sqlSession.update("net.wanho.mapper.StudentMapper.addStu",student);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDelStu() {
        SqlSession session= MybatisUtil.getSession();
        sqlSession.update("net.wanho.mapper.StudentMapper.delStu",5);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
    @Test
    public void testUpdateStu() {
        Student student=new Student(5,"rss",22,"男","南京");
        sqlSession.update("net.wanho.mapper.StudentMapper.updateStu",student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetAllStu() {
        SqlSession session= MybatisUtil.getSession();
        List<Student> students = session.selectList("net.wanho.mapper.StudentMapper.getAllStus");
        System.out.println(students);
        MybatisUtil.closeSession();
    }

    @Test
    public void testGetStuById() {
//        SqlSession session= MybatisUtil.getSession();
//        Student student = session.selectOne("net.wanho.mapper.StudentMapper.getStuById",2);
//        System.out.println(student);
//        MybatisUtil.closeSession();
        Student student =studentMapper.getStuById(2);
        System.out.println(student);
        MybatisUtil.closeSession();
    }

    @Test
    public void testgetStuByName(){
        List<Student> students = studentMapper.getStuByName("纪");
        System.out.println(students);
        MybatisUtil.closeSession();
    }

    @Test
    public void testaddStuReturnKey2(){
        Student student=new Student(null,"rsss",22,"男","南京");
        studentMapper.addStuReturnKey2(student);
        System.out.println(student.getId());
        sqlSession.commit();
        MybatisUtil.closeSession();
    }
    
    @Test
    public void testupdateStuById(){
        Student student=new Student(2,"rsss",22,"男","南京");
        studentMapper.updateStuById("bbbb","北京",2);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void testupdateStuById2(){
        Student student=new Student(2,"xxx",33,"男","南京");
        studentMapper.updateStuById2(student,2);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void updateStuById3() {
        Student student=new Student(2,"qqq",22,"男","南京");
        studentMapper.updateStuById2(student,2);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

}
