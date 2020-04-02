package br.com.mind5.dao;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class DaoStmtExecOption<T extends InfoRecord> implements Cloneable {
	public Connection conn;
	public T recordInfo;
	public String schemaName;
	
	
	public DaoStmtExecOption() {
		clear();
	}
		
	
	public void clear() {
		conn = DefaultValue.object();
		recordInfo = DefaultValue.object();
		schemaName = DefaultValue.object();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		DaoStmtExecOption<T> result = new DaoStmtExecOption<>();
		
		result.conn = conn;
		result.schemaName = schemaName;
		result.recordInfo = cloneRecord(recordInfo);
		
		return result;		
	}  
	
	
	
	@SuppressWarnings("unchecked")
	private T cloneRecord(T source) throws CloneNotSupportedException {
		if (source == null)
			return null;
		
		return (T) source.clone();
	}
}
