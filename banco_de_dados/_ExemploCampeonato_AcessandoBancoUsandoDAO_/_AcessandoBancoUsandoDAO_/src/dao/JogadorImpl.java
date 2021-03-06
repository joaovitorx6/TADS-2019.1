package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import campeonato.Jogador;
import campeonato.Jogo;
import campeonato.Time;

public class JogadorImpl implements JogadorDAO {

	@Override
	public List<Jogador> listarTodosJogadores() {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		List jogadorAL = new ArrayList();
		Jogador jogador;
		try {
			conn = ProvedorConexao.getConnection();
			String selectSQL = "SELECT * FROM Jogador";
			preparedStatement = conn.prepareStatement(selectSQL);
			ResultSet jogadorRS = preparedStatement.executeQuery(selectSQL);

			while(jogadorRS.next()){
				jogador = new Jogador(jogadorRS.getInt("cod"), jogadorRS.getString("nome"), jogadorRS.getInt("idade"), jogadorRS.getInt("time_cod"));
				jogadorAL.add(jogador);
			}

			return jogadorAL;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Jogador verJogadorPorCodigo(int codigo) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
//		criando objeto de time.
		Jogador jogador=null;
		try{
			conn = ProvedorConexao.getConnection();
			String selectItemSQL = "SELECT * FROM jogador WHERE cod = "+codigo;
			preparedStatement = conn.prepareStatement(selectItemSQL);
//			preparedStatement.setInt(1, codigo);
			ResultSet jogadorRS = preparedStatement.executeQuery(selectItemSQL);
			while (jogadorRS.next()){
				jogador = new Jogador (jogadorRS.getInt("cod"),jogadorRS.getString("nome"), jogadorRS.getInt("idade"), jogadorRS.getInt("time_cod"));
			}
			return jogador;
		}catch (SQLException e){
			e.printStackTrace();
		}
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
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String deleteTimeSql = "DELETE FROM jogador WHERE cod=?";
			preparedStatement = conn.prepareStatement(deleteTimeSql);
			preparedStatement.setInt(1,jogador.getCod());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarJogador(Jogador jogador) {
		// TODO Auto-generated method stub

	}

}
