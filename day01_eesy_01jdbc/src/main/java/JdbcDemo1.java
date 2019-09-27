import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/20 19:17
 *
 * 程序耦合
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
//        Connection con = DriverManager.getConnection("jdbc:mysql//localhost:3306/eesy", "root", "123456");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql//localhost:3306/eesy", "root", "123456");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = con.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        con.close();
    }
}
