package dao;

import campeonato.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogo verJogoPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarJogo(Jogo jogo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarJogo(Jogo jogo) {
		// TODO Auto-generated method stub
		
	}
}
