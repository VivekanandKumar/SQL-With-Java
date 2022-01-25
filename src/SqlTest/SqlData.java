package SqlTest;

import java.sql.*;


public class SqlData {
//  calling connectDb() method from MyConnection class.
    Connection conn = MyConnection.connectDb();
    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    {
        try {
            assert conn != null;
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Function to display data from a sql database table;
    void display() throws SQLException {
        String query = "Select * from test";
        rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.printf("%-10d%-30s%d", rs.getInt(1), rs.getString(2), rs.getInt(3));
            System.out.println();
        }
        rs.close();
    }
//  Function to insert data into a sql database table;
    void insert(String name, int rollNo) throws SQLException {
        String query = "insert into test (FullName,RollNo) values(?,?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, rollNo);
        ps.execute();

        ps.close();
    }
//  Function to delete data from a sql database table;
    void delete(int rollNo) throws SQLException {
        String query = "delete from test where RollNo = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, rollNo);
        System.out.println(ps.executeUpdate());
        ps.close();
    }

    public static void main(String[] args) throws Exception {
        SqlData dd = new SqlData();
//        dd.insert("xyz", 56);
//        dd.display();
//        dd.delete(56);
    }
}