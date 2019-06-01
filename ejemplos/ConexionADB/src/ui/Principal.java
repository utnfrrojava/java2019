package ui;

import java.sql.*;
import java.util.Scanner;

import entities.Documento;
import entities.Persona;

public class Principal {
	
	private static String driver="com.mysql.jdbc.Driver";

	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet keyResultSet=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(driver);// equivalente a new com.mysql.jdbc.Driver();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "java", "java2019");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("SELECT * FROM persona");
			if (rs!=null) {
				while(rs.next()) {
					Persona p=new Persona();
					p.setDocumento(new Documento());
					p.setId(rs.getInt("id"));
					p.getDocumento().setTipo(rs.getString("tipo_doc"));
					p.getDocumento().setNro(rs.getString("nro_doc"));
					p.setApellido(rs.getString("apellido"));
					p.setNombre(rs.getString("nombre"));
					p.setEmail(rs.getString("email"));
					p.setTel(rs.getString("tel"));
					
					System.out.println(p);
					
					
				}
			}
			
			Persona pIns=new Persona();
			pIns.setDocumento(new Documento());
			
			
			Scanner s= new Scanner(System.in);
			System.out.print("tipo doc: ");
			pIns.getDocumento().setTipo(s.nextLine());
			System.out.print("nro doc: ");
			pIns.getDocumento().setNro(s.nextLine());
			System.out.print("nombre: ");
			pIns.setNombre(s.nextLine());
			System.out.print("apellido: ");
			pIns.setApellido(s.nextLine());
			System.out.print("email: ");
			pIns.setEmail(s.nextLine());
			System.out.print("tel: ");
			pIns.setTel(s.nextLine());
			
			
			
			
			
			pstmt=conn.prepareStatement("insert into persona(tipo_doc,nro_doc,nombre,apellido,email,tel) values(?,?,?,?,?,?)"
					,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, pIns.getDocumento().getTipo());
			pstmt.setString(2, pIns.getDocumento().getNro());
			pstmt.setString(3, pIns.getNombre());
			pstmt.setString(4, pIns.getApellido());
			pstmt.setString(5, pIns.getEmail());
			pstmt.setString(6, pIns.getTel());
			
			pstmt.executeUpdate();
			
			keyResultSet=pstmt.getGeneratedKeys();
			
			if(keyResultSet!=null && keyResultSet.next()) {
				int id=keyResultSet.getInt(1);
				System.out.println("ID: "+id);
				pIns.setId(id);
			}
			
			s.close();
			
			System.out.println();
			System.out.println(pIns);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {pstmt.close();}
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				if(conn!=null && !conn.isClosed()) { conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
