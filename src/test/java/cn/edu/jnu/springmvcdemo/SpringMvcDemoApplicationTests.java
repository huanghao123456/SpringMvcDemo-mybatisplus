package cn.edu.jnu.springmvcdemo;

import cn.edu.jnu.springmvcdemo.dao.StudentDao;
import cn.edu.jnu.springmvcdemo.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringMvcDemoApplicationTests {

	@Autowired
	private StudentDao studentDao;
	@Test
	void contextLoads() {
		List<Student> students = studentDao.selectList(null);
		System.out.println("students = " + students);
	}

	@Test
	void test2() {
		System.out.println(studentDao.selectById(1));
	}

	@Test
	void test3() {
		Student student = new Student();
		student.setId(2);
		student.setAge(22);
		student.setUserName("hhhhhhh");

		studentDao.updateById(student);
	}
}
