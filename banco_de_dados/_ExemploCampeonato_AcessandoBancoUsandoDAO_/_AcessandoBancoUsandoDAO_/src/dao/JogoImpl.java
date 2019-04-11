package dao;

import campeonato.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JogoImpl implements JogoDAO {

	@Override
	public void salvarJogo(Jogo jogo) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Jogo"
					+ "(cod, timea_cod, timeb_cod, resultado) VALUES"
					+ "(?,?,?,?)";
				
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, jogo.getCod());
				preparedStatement.setInt(2, jogo.getTimea_cod());
				preparedStatement.setInt(3, jogo.getTimeb_cod());
				preparedStatement.setString(4, jogo.getResultado());
				int resultado = preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Jogo> listarTodosJogos() {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		List jogosAL = new ArrayList();
		Jogo jogo;
		try {
			conn = ProvedorConexao.getConnection();
			String selectSQL = "SELECT * FROM Jogo";
			preparedStatement = conn.prepareStatement(selectSQL);
			ResultSet jogoRS = preparedStatement.executeQuery(selectSQL);
				
				while(jogoRS.next()){
					jogo = new Jogo(jogoRS.getInt("cod"), jogoRS.getInt("timea_cod"), jogoRS.getInt("timeb_cod"), jogoRS.getString("resultado"));
					jogosAL.add(jogo);
				}
				
				return jogosAL;
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Jogo verJogoPorCodigo(int codigo) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
//		criando objeto de time.
		Jogo jogo=null;
		try{
			conn = ProvedorConexao.getConnection();
			String selectItemSQL = "SELECT * FROM jogo WHERE cod = "+codigo;
			preparedStatement = conn.prepareStatement(selectItemSQL);
//			preparedStatement.setInt(1, codigo);
			ResultSet jogoRS = preparedStatement.executeQuery(selectItemSQL);
			while (jogoRS.next()){
				jogo = new Jogo (jogoRS.getInt("cod"),jogoRS.getInt("timea_cod"), jogoRS.getInt("timeb_cod"), jogoRS.getString("resultado"));
			}
			return jogo;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deletarJogo(Jogo jogo) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String deleteTimeSql = "DELETE FROM jogo WHERE cod=?";
			preparedStatement = conn.prepareStatement(deleteTimeSql);
			preparedStatement.setInt(1,jogo.getCod());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarJogo(Jogo jogo) {
		// TODO Auto-generated method stub
		
	}
}
