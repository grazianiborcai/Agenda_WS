package br.com.mind5.model.decisionTree.temp;

import java.sql.Connection;
import java.util.List;

public interface DeciTreeOptionV2<T> {
	public List<T> getRecordInfos();
	
	public Connection getConn();
	
	public String getSchemaName();
}
