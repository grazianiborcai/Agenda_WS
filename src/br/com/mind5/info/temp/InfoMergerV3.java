package br.com.mind5.info.temp;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface InfoMergerV3<T extends InfoRecord, K extends InfoRecord> {	
	public List<T> merge();
}
