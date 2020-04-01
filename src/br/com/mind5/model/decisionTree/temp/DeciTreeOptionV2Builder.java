package br.com.mind5.model.decisionTree.temp;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class DeciTreeOptionV2Builder<T extends InfoRecord> {
	private List<T> recordInfos;
	private Connection conn;
	private String schemaName;
	
	
	public void addRecords(List<T> records) {
		if (isArgumentValid(records))
			recordInfos = DeciTreeUtil.copyOf(records);
		
		recordInfos = null;
	}
	
	
	
	public void addConn(Connection c) {
		conn = c;
	}
	
	
	
	public void addSchemaName(String name) {
		schemaName = name;
	}
	
	
	
	public DeciTreeOptionV2<T> build() {
		checkArgument(recordInfos, conn, schemaName);
		
		List<T> copies = DeciTreeUtil.copyOf(recordInfos);	
		return (DeciTreeOptionV2<T>) new DeciTreeOptionV2Helper<>(copies, conn, schemaName);
	}
	
	
	
	private void checkArgument(List<T> records, Connection c, String name) {
		if (isArgumentValid(records) == false) {
			logException(new NullPointerException("recordInfos" + SystemMessage.ILLEGAL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.ILLEGAL_ARGUMENT);
		}
		
		
		if (isArgumentValid(c) == false) {
			logException(new NullPointerException("connection" + SystemMessage.ILLEGAL_ARGUMENT));
			throw new NullPointerException("connection" + SystemMessage.ILLEGAL_ARGUMENT);
		}
		
		
		if (isArgumentValid(name) == false) {
			logException(new NullPointerException("SchemaName" + SystemMessage.ILLEGAL_ARGUMENT));
			throw new NullPointerException("SchemaName" + SystemMessage.ILLEGAL_ARGUMENT);
		}
	}	
	
	
	
	private boolean isArgumentValid(List<T> records) {
		if (records == null)
			return false;
		
		if (records.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private boolean isArgumentValid(Connection c) {
		if (c == null)
			return false;
		
		return true;
	}
	
	
	
	private boolean isArgumentValid(String name) {
		if (name == null)
			return false;
		
		return true;
	}	
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}	
}
