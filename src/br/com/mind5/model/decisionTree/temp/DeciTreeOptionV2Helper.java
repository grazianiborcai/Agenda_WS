package br.com.mind5.model.decisionTree.temp;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.info.InfoRecord;

final class DeciTreeOptionV2Helper<T extends InfoRecord> implements DeciTreeOptionV2<T> {
	private final List<T> recordInfos;
	private final Connection conn;
	private final String schemaName;
	
	
	protected DeciTreeOptionV2Helper(List<T> records, Connection c, String name) {
		recordInfos = records;
		conn = c;
		schemaName = name;
	}
	
	

	@Override public List<T> getRecordInfos() {
		return DeciTreeUtil.copyOf(recordInfos);
	}
	
	
	
	@Override public Connection getConn() {
		return conn;
	}
	
	
	
	@Override public String getSchemaName() {
		return schemaName;
	}
}
