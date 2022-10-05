package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcontactsmvc?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "admin";
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void insertC(JavaBeans contato) {
		String insrtC = "insert into contatos (nome, fone, email, idusucontac) values (?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insrtC);
			pst.setString(1, contato.getNome_ctt());
			pst.setString(2, contato.getFone_ctt());
			pst.setString(3, contato.getEmail_ctt());
			pst.setInt(4, contato.getIdusuario_usr());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<JavaBeans> arrayC(JavaBeans contato){
		
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		
		String selA = "select * from contatos where idusucontac = ? order by nome";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(selA);
			pst.setInt(1, contato.getIdusuario_usr());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				contatos.add(new JavaBeans(idcon,nome,fone,email));	
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	public void selectC(JavaBeans contato) {
		String selC = "select * from contatos where idcontatos = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(selC);
			pst.setInt(1, contato.getIdcontatos_ctt());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				contato.setIdcontatos_ctt(rs.getInt(1));
				contato.setNome_ctt(rs.getString(2));
				contato.setFone_ctt(rs.getString(3));
				contato.setEmail_ctt(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void updateC(JavaBeans contato) {
		String upD = "update contatos set nome = ?, fone = ?, email = ? where idcontatos = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(upD);
			pst.setString(1, contato.getNome_ctt());
			pst.setString(2, contato.getFone_ctt());
			pst.setString(3, contato.getEmail_ctt());
			pst.setInt(4, contato.getIdcontatos_ctt());
			
			pst.executeUpdate();
			con.close();
	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteC(JavaBeans contato) {
		String del = "delete from contatos where idcontatos = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setInt(1, contato.getIdcontatos_ctt());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean verifC(JavaBeans contato) {
		String vefC = "select * from usuario where email = ?";
		String emailCon;
		boolean status = false;
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(vefC);
			pst.setString(1, contato.getEmail_usr());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				emailCon = rs.getString(3);

				if(emailCon.equals(contato.getEmail_usr())) {
					status = true;
				}
			}
			con.close();
			return status;
		} catch (Exception e) {
			System.out.println(e);
			return status;
		}
	}
	
	public boolean verifC_Login(JavaBeans contato) {
		String vefCL = "select * from usuario where email = ?";
		String emailCon;
		String senhaCon;
		boolean status = false;
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(vefCL);
			pst.setString(1, contato.getEmail_usr());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				emailCon = rs.getString(3);
				senhaCon = rs.getString(4);

				if(emailCon.equals(contato.getEmail_usr()) && senhaCon.equals(contato.getSenha_usr())) {
					contato.setIdusuario_usr(rs.getInt(1));
					contato.setNome_usr(emailCon);
					contato.setEmail_usr(rs.getString(3));
					contato.setSenha_usr(rs.getString(4));
					status = true;
				}
			}
			con.close();
			return status;
		} catch (Exception e) {
			System.out.println(e);
			return status;
		}
	}
	
	public void insertU(JavaBeans contato) {
		String insrU = "insert into usuario (nome, email, senha) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insrU);
			pst.setString(1, contato.getNome_usr());
			pst.setString(2, contato.getEmail_usr());
			pst.setString(3, contato.getSenha_usr());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void lixeiraC(JavaBeans contato) {
		String lix = "insert into lixeira select * from contatos where idcontatos = ?";
	
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(lix);
			pst.setInt(1, contato.getIdcontatos_ctt());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> arrayLixeiraC(JavaBeans contato) {

		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String selLixC = "select * from lixeira where idusucontac = ? order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(selLixC);
			pst.setInt(1, contato.getIdusuario_usr());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void lixeiraRest(JavaBeans contato) {
		String rest = "insert into contatos select * from lixeira where idcontatos = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(rest);
			pst.setInt(1, contato.getIdcontatos_ctt());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deleteLixeira(JavaBeans contato) {
		String delL = "delete from lixeira where idcontatos = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delL);
			pst.setInt(1, contato.getIdcontatos_ctt());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deleteAll() {
		String delT = "delete from lixeira";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delT);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
