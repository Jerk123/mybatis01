package net.wanho.mapper;

import net.wanho.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Jerk on 2019/6/5.
 */
public interface StudentMapper {

    List<Student> getAllStus();

    Student getStuById(int id);

    void addStu(Student student);

    void delStu(int id);

    void updateStu(Student student);

    List<Student> getStuByName(String name);

    void addStuReturnKey(Student student);

    void addStuReturnKey2(Student student);

    void updateStuById(@Param("sname") String sname, @Param("address") String address, @Param("id") Integer id);

    void updateStuById2(@Param("stu") Student student, @Param("id") Integer id);

    /**
     * @param student
     * @param id
     * 可以这么写，了解，别觉得奇怪
     */
    @Update( "UPDATE student SET sname = #{stu.sname}, address = #{stu.address} WHERE id = #{id})")
    void updateStuById3(@Param("stu") Student student, @Param("id") Integer id);
}
