package message.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.jdbc.Statement;

import message.dao.Dao;
import message.db.JDBCUtil;
import message.util.ReflectionUtils;

public class BaseDao<T> implements Dao<T> {

	QueryRunner queryRunner = new QueryRunner();
	Class<T> clazz;
	public BaseDao() {
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}
	@Override
	public long insert(String sql, Object... args) {
		
		long id = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if(args != null){
				for( int i = 0 ; i < args.length ; i++){
					preparedStatement.setObject(i + 1, args[i]);					
				}
			}
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()){
				id = resultSet.getLong(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(resultSet, preparedStatement);
			JDBCUtil.release(connection);
		}
		return id;
	}

	@Override
	public void update(String sql, Object... args) {

		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(connection);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E getSingleValue(String sql, Object... args) {
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			return (E)queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(connection);
		}
		return null;
	}

	@Override
	public T get(String sql, Object... args) {
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			return (T) queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(connection);
		}
		return null;
	}

	@Override
	public List<T> getForList(String sql, Object... args) {
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			return (List<T>) queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(connection);
		}
		return null;
	}

}
