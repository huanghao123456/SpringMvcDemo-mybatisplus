package cn.edu.jnu.springmvcdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Student {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String phone;
    private Integer sex;
    private Integer age;
}
