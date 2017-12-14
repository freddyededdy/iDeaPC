package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public interface Model_Interface<A>{
	public void  insert(A entity) throws SQLException;
	public void update(A entity) throws SQLException;
	public boolean remove(int id) throws SQLException;
	public A findByKey(int id) throws SQLException;
	public Collection<A> findAll() throws SQLException;
}


