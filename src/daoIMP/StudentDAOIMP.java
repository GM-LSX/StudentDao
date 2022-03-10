package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
    // 添加操作
    @Override
    public void insert(Student s){
        String sql = "INSERT INTO student (id, name) values (?,?)";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //针对数据库的具体操作
        try{
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1,s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2,s.getName());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){  }
    }

    public void update(Student s) {
        String sql="update student set name=? where id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);

            pstmt.setString(1,s.getName());
            pstmt.setInt(2,s.getID());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        String sql="delete  from student where id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,id);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public Student findByID(int id) {
        String sql="select * from student where id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        Student res=new Student();
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet set = pstmt.executeQuery();

            while (set.next()) {
                Integer id1 = set.getInt(1);
                String name = set.getString(2);
                System.out.println("id:" + set.getInt(1) + " name:" + set.getString(2));
                res.setID(id1);
                res.setName(name);
            }
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Student> findAll() {
        String sql="select * from student ";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        List<Student> list=new ArrayList<>();
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {
                Integer id1 = set.getInt(1);
                String name = set.getString(2);
                Student student = new Student(id1, name);
                list.add(student);
            }
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}


