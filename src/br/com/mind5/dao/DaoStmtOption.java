package br.com.mind5.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public final class DaoStmtOption<T> implements Cloneable {
	public Connection conn;
	public T recordInfo;
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<DaoColumn> columns;
	public DaoStmtParamTranslator<T> stmtParamTranslator;
	public DaoResultParser<T> resultParser;
	public List<DaoJoin> joins;
	
	
	@SuppressWarnings("unchecked")
	@Override public Object clone()throws CloneNotSupportedException {  
		try {
			DaoStmtOption<T> deepCopy = (DaoStmtOption<T>) super.clone(); 
			deepCopy.recordInfo = (T) recordInfo.getClass().getMethod("clone").invoke(recordInfo);
			
			
			if (columns != null) {
				List<DaoColumn> clonedColumns = new ArrayList<>();
				for (DaoColumn eachColumn : columns) {
					clonedColumns.add((DaoColumn) eachColumn.clone());
				}			
			
				deepCopy.columns = clonedColumns;
			}			
			
			return deepCopy;
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CloneNotSupportedException();
		} 		
	}  
}
