package br.com.mind5.info;

import java.util.List;

public interface InfoPrunerListVisitor<T extends InfoRecord, S extends InfoRecord> {
	
	public List<T> pruneRecord(List<T> baseInfos, List<S> selectedInfos);
}
