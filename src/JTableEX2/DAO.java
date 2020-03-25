package JTableEX2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private static DAO DAOobj;

	private DAO() {
	}

	static { // 클래스가 생성될때 얘는 공용으로 딱 한번만 실행이 됩니다.. 다시는 두번다시 수행 안하죠..
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패:" + e.getMessage());
		}
	}

	public static DAO getInstance() {
		if (DAOobj == null) {
			DAOobj = new DAO();
		}
		return DAOobj;
	}

	private boolean connect() {
		boolean result = false;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패:" + e.getMessage());
		}
		return result;
	}

	// 위 까지가 데이터베이스 드라이브 로드와 연결을 정의한 코딩
	public boolean InsertGrade(DTOGrade grade) {
		boolean result = false;
		if (this.connect()) {
			try {
				String sql = "INSERT INTO grade VALUES (?,?,?,?)";
				// 쿼리 문장을 미리 생성해 놓도 다음에 바인딩해라.. 그리고 완성되면 질의를 던져라..
				PreparedStatement psmt = conn.prepareStatement(sql);
				// 바인딩하자
				psmt.setString(1, grade.getName());
				psmt.setString(2, grade.getJ1());
				psmt.setString(3, grade.getJ2());
				psmt.setString(4, grade.getJ3());

				int r = psmt.executeUpdate();

				if (r > 0) {
					result = true;
				}
				psmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}

		return result;
	}
	public ArrayList<String[]> getList(){
		ArrayList<String[]> list= new ArrayList();
		String sql="SELECT * FROM grade";
		if(connect()) {
			try {
				stmt=conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql);  // rs는 sql을 실행한 튜플 단위로 가져온다.
					while(rs.next()) {
						DTOGrade grade = new DTOGrade();
						
						grade.setName(rs.getString("name"));
						grade.setJ1(rs.getString("j1"));
						grade.setJ2(rs.getString("j2"));
						grade.setJ3(rs.getString("j3"));
						
						list.add(grade.getArray());
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}
		return list;
	}
	
	
	
}











