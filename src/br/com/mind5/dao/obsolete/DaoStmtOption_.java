package br.com.mind5.dao.obsolete;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoStmtParamTranslator;

public final class DaoStmtOption_<T> implements Cloneable {
	public Connection conn;
	public T recordInfo;
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<DaoColumn> columns;
	public DaoStmtParamTranslator<T> stmtParamTranslator;
	public DaoResultParser_<T> resultParser;
	public List<DaoJoin> joins;
	
	
	@SuppressWarnings("unchecked")
	@Override public Object clone()throws CloneNotSupportedException {  
		try {
			DaoStmtOption_<T> deepCopy = (DaoStmtOption_<T>) super.clone(); 
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
