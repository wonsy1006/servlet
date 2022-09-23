package servletdb2.ex01;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@KXBOYAQTZZXROEXP_high?TNS_ADMIN=/Users/wonsoyeon/Wallet_KXBOYAQTZZXROEXP";
	private static final String user = "ADMIN";
	private static final String pwd = "Oracledatabase01";
	private Connection con = null;
	private Statement stmt;
	
	// 회원정보 목록
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			
			String query = "select * from member_list";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joindate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Error occured");
		}
		return list;
	}
	
	// Database connection status
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle driver loaded successfully");
			
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println(con);
			System.out.println("Connection creation succeeded");
			
			stmt = con.createStatement();
			System.out.println(stmt);
		} catch (Exception e) {
			System.out.println("Database connection failed");
		}
	}
}
