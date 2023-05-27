package cn.edu.jnu.springmvcdemo.dao;

import cn.edu.jnu.springmvcdemo.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
