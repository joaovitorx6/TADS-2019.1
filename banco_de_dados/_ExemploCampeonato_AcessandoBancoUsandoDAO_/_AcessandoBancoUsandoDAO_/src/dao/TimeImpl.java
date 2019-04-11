package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import campeonato.Time;

public class TimeImpl implements TimeDAO{

	@Override
	public List<Time> listarTodosTimes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time verTimePorCodigo(int codigo) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
//		criando objeto de time.
		Time time=null;
		try{
			conn = ProvedorConexao.getConnection();
			String selectItemSQL = "SELECT * FROM time WHERE cod = "+codigo;
			preparedStatement = conn.prepareStatement(selectItemSQL);
//			preparedStatement.setInt(1, codigo);
			ResultSet timeRS = preparedStatement.executeQuery(selectItemSQL);
			while (timeRS.next()){
				time = new Time (timeRS.getInt("cod"), timeRS.getString("nome"), timeRS.getString("data_fundacao"));
			}
			return time;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void salvarTime(Time time) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Time"
					+ " (cod, nome, data_fundacao) VALUES"
					+ "(?,?,?)";
				
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, time.getCod());
				preparedStatement.setString(2, time.getNome());
				preparedStatement.setString(3, time.getDatafundacao());
				int resultado = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletarTime(Time time) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String deleteTimeSql = "DELETE FROM time WHERE cod=?";
			preparedStatement = conn.prepareStatement(deleteTimeSql);
			preparedStatement.setInt(1,time.getCod());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarTime(Time time) {
		// TODO Auto-generated method stub
		
	}

}
