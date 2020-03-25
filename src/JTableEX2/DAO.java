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

	static { // Ŭ������ �����ɶ� ��� �������� �� �ѹ��� ������ �˴ϴ�.. �ٽô� �ι��ٽ� ���� ������..
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� �ε� ����:" + e.getMessage());
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
			System.out.println("���� ����:" + e.getMessage());
		}
		return result;
	}

	// �� ������ �����ͺ��̽� ����̺� �ε�� ������ ������ �ڵ�
	public boolean InsertGrade(DTOGrade grade) {
		boolean result = false;
		if (this.connect()) {
			try {
				String sql = "INSERT INTO grade VALUES (?,?,?,?)";
				// ���� ������ �̸� ������ ���� ������ ���ε��ض�.. �׸��� �ϼ��Ǹ� ���Ǹ� ������..
				PreparedStatement psmt = conn.prepareStatement(sql);
				// ���ε�����
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
			System.out.println("DB���� ����");
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
					rs = stmt.executeQuery(sql);  // rs�� sql�� ������ Ʃ�� ������ �����´�.
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
			System.out.println("DB���� ����");
			System.exit(0);
		}
		return list;
	}
	
	
	
}











