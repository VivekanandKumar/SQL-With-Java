package SqlTest;

import java.sql.*;


public class SqlData {

    Connection conn = MyConnection.connectDb();
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    {
        try{
            assert conn != null;
            st = conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void display() throws Exception{
        String query = "Select * from test";
        rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.printf("%-10d%-30s%d", rs.getInt(3), rs.getString(1), rs.getInt(2));
            System.out.println();
        }
        rs.close();
    }

    void insert(String name,int rollNo) throws SQLException {
        String query = "insert into test (Name,Roll_No) values(?,?)";
        ps = conn.prepareStatement(query);
        ps.setString(1,name);
        ps.setInt(2,rollNo);
        ps.execute();

        ps.close();
    }
    void delete(int rollNo) throws SQLException {
        String query = "delete from test where Roll_No = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1,rollNo);
        System.out.println(ps.executeUpdate());
        ps.close();
    }

    public static void main(String[] args) throws Exception {
        SqlData dd = new SqlData();
        dd.insert("Sangita Devi",101);
        dd.display();
        dd.delete(101);
    }
}