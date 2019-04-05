package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import campeonato.Jogador;

public class JogadorImpl implements JogadorDAO {

	@Override
	public List<Jogador> listarTodosJogadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogador verJogadorPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarJogador(Jogador jogador) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Jogador"
					+ "(cod, nome, idade, time_cod) VALUES"
					+ "(?,?,?,?)";
				
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, jogador.getCod());
				preparedStatement.setString(2, jogador.getNome());
				preparedStatement.setInt(3, jogador.getIdade());
				preparedStatement.setInt(4, jogador.getTime_cod());
				int resultado = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletarJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

}
