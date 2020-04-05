package br.com.mind5.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;


public final class DaoStmtOption<T extends InfoRecord> implements Cloneable {
	public Connection conn;
	public T recordInfo;
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<DaoColumn> columns;
	public DaoStmtParamTranslator<T> stmtParamTranslator;
	public DaoResultParser<T> resultParser;
	public List<DaoJoin> joins;	
	
	
	public DaoStmtOption() {
		clear();
	}
	
	
	
	public void clear() {
		conn = DefaultValue.object();
		recordInfo = DefaultValue.object();
		schemaName = DefaultValue.object();
		tableName = DefaultValue.object();
		whereClause = DefaultValue.object();
		columns = DefaultValue.list();
		stmtParamTranslator = DefaultValue.object();
		resultParser = DefaultValue.object();
		joins = DefaultValue.list();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		DaoStmtOption<T> deepCopy = new DaoStmtOption<>();
		
		deepCopy.conn = conn;
		deepCopy.schemaName = schemaName;
		deepCopy.tableName = tableName;
		deepCopy.whereClause = whereClause;
		deepCopy.stmtParamTranslator = stmtParamTranslator;
		deepCopy.resultParser = resultParser;		
		deepCopy.recordInfo = cloneRecord(recordInfo);
		deepCopy.columns = cloneColumns(columns);
		deepCopy.joins = cloneJoins(joins);
		
		return deepCopy;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private T cloneRecord(T source) throws CloneNotSupportedException {
		if (source == null)
			return null;
		
		return (T) source.clone();
	}
	
	
	
	private List<DaoColumn> cloneColumns(List<DaoColumn> sources) throws CloneNotSupportedException {
		if (sources == null)
			return null;
		
		List<DaoColumn> results = new ArrayList<>();
		
		for (DaoColumn eachSource : sources) {
			DaoColumn clonedSource = (DaoColumn) eachSource.clone();
			results.add(clonedSource);
		}
		
		return results;
	}
	
	
	
	private List<DaoJoin> cloneJoins(List<DaoJoin> sources) throws CloneNotSupportedException {
		if (sources == null)
			return null;
		
		List<DaoJoin> results = new ArrayList<>();
		
		for (DaoJoin eachSource : sources) {
			DaoJoin clonedSource = (DaoJoin) eachSource.clone();
			results.add(clonedSource);
		}
		
		return results;
	}
}
