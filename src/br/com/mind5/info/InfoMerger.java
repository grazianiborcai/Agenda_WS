package br.com.mind5.info;

import java.util.List;

public interface InfoMerger<T extends InfoRecord, K extends InfoRecord> {	
	public List<T> merge();
}
