package br.com.mind5.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.info.InfoRecord;

public final class DeciTreeOption<T extends InfoRecord> implements Cloneable {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		DeciTreeOption<T> deepCopy = new DeciTreeOption<>();
		
		deepCopy.recordInfos = cloneRecords(recordInfos);
		deepCopy.conn = conn;
		deepCopy.schemaName = schemaName;
		
		return deepCopy; 		
	}
	
	
	
	private List<T> cloneRecords(List<T> sources) {
		return CloneUtil.cloneRecords(sources, this.getClass());
	}
}
