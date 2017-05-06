package message.dao;

import java.util.List;

public interface Dao<T> {
	/**
	 * 执行INSERT操作,返回插入后记录的ID
	 * @param sql
	 * @param args
	 * @return
	 */
	long insert(String sql,Object ... args);
	
	/**
	 * 执行 UPDATE 操作, 包括 INSERT(但没有返回值), UPDATE, DELETE
	 * @param sql
	 * @param args
	 */
	void update(String sql,Object ... args);
	
	/**
	 * 执行单条记录的查询操作, 返回与记录对应的类的一个对象
	 * @param sql
	 * @param args
	 * @return
	 */
	<E> E getSingleValue(String sql,Object ... args);
	
	/**
	 * 执行单条记录的查询操作, 返回与记录对应的类的一个对象
	 * @param sql
	 * @param args
	 * @return
	 */
	T get(String sql,Object ... args);
	
	/**
	 * 执行多条记录的查询操作, 返回与记录对应的类的一个 List
	 * @param sql: 待执行的 SQL 语句
	 * @param args: 填充占位符的可变参数
	 * @return: 与记录对应的类的一个 List
	 */
	List<T> getForList(String sql,Object ... args);
	
	
	
}
