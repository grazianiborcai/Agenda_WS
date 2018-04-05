package br.com.gda.sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public final class SqlStmtOption<T> implements Cloneable {
	public Connection conn;
	public T recordInfo;
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<SqlColumn> columns;
	public SqlStmtParamTranslator<T> stmtParamTranslator;
	public SqlResultParser<T> resultParser;
	
	
	@SuppressWarnings("unchecked")
	@Override public Object clone()throws CloneNotSupportedException {  
		try {
			SqlStmtOption<T> deepCopy = (SqlStmtOption<T>) super.clone(); 
			deepCopy.recordInfo = (T) recordInfo.getClass().getMethod("clone").invoke(recordInfo);
			
			
			if (deepCopy.columns != null) {
				List<SqlColumn> clonedColumns = new ArrayList<>();
				for (SqlColumn eachColumn : columns) {
					clonedColumns.add((SqlColumn) eachColumn.clone());
				}			
			
				deepCopy.columns = clonedColumns;
			}
			
			
			return deepCopy;
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CloneNotSupportedException();
		} 		
	}  
}
