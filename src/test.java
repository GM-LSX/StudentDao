import bean.Student;
import daoIMP.StudentDAOIMP;
import org.junit.Test;

import java.util.List;

public class test {

    /**
     * 测试insert
     */
    @Test
    public void test1() {
        StudentDAOIMP daoimp = new StudentDAOIMP();
        Student student = new Student(2, "测试");
        daoimp.insert(student);
    }

    /**
     * 测试update
     */
    @Test
    public void test2() {
        StudentDAOIMP daoimp = new StudentDAOIMP();
        Student student = new Student(2, "测试update");
        daoimp.update(student);
    }

    /**
     * 测试delete
     */

    @Test
    public void test3() {
        StudentDAOIMP daoimp = new StudentDAOIMP();
        daoimp.delete(2);

    }

    /**
     * 测试findByID
     */

    @Test
    public void test4() {
        StudentDAOIMP daoimp = new StudentDAOIMP();
        Student byID = daoimp.findByID(1);
        System.out.println(byID);
    }

    /**
     * 测试findAll
     */
    @Test
    public void test5() {
        StudentDAOIMP daoimp = new StudentDAOIMP();
        List<Student> all = daoimp.findAll();
        all.stream().forEach(student -> {
            System.out.println(student);
        });
    }

}
