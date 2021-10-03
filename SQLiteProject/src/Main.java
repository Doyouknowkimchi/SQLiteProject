import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
		Connection con = null;
		// TODO Auto-generated method stub
		try {
			Class.forName("org.sqlite.JDBC");
			
			String dbfile = "C:\\Users\\dragu\\Desktop\\SQL\\sqlite-tools-win32-x86-3360000\\myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbfile);
			
			System.out.println("\n*** ������ ��ȸ ***");
			Statement stat1 = con.createStatement();
			String sql1 = "select * from g_artists"; //sql ����
			ResultSet rs1 = stat1.executeQuery(sql1);
			while(rs1.next()) {
				String id = rs1.getString("id");
				String name = rs1.getString("name");
				System.out.println(id + " " + name);
			}
			stat1.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {}
			}
		}
	}

}
