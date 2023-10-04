package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	private Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}

	public void criarContato(JavaBeans contato) {
		String sql = "INSERT INTO contatos (nome,telefone,email) VALUES(?,?,?)";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setNString(1, contato.getNome());
			pstm.setNString(2, contato.getTelefone());
			pstm.setNString(3, contato.getEmail());
			pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String sql = "SELECT * FROM contatos";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			while (rset.next()) {
				int contato_id = rset.getInt(1);
				String nome = rset.getNString(2);
				String telefone = rset.getNString(3);
				String email = rset.getNString(4);
				contatos.add(new JavaBeans(contato_id, nome, telefone, email));
			}
			conn.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void selecionarContato(JavaBeans contato) {
		String sql = "SELECT * FROM contatos WHERE contato_id = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, contato.getContato_id());
			ResultSet rset = pstm.executeQuery();
			while (rset.next()) {
				contato.setContato_id(rset.getInt(1));
				contato.setNome(rset.getNString(2));
				contato.setTelefone(rset.getNString(3));
				contato.setEmail(rset.getNString(4));
			}
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarContato(JavaBeans contato) {
		String sql = "UPDATE contatos SET nome=?,telefone=?,email=? WHERE contato_id=?";

		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setNString(1, contato.getNome());
			pstm.setNString(2, contato.getTelefone());
			pstm.setNString(3, contato.getEmail());
			pstm.setInt(4, contato.getContato_id());
			pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deletarrContato(JavaBeans contato) {
		String sql = "DELETE FROM contatos WHERE contato_id=?";
		try {
			Connection conn = conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, contato.getContato_id());
			pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
