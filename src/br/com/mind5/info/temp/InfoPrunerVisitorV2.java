package br.com.mind5.info.temp;

import br.com.mind5.info.InfoRecord;

public interface InfoPrunerVisitorV2<T extends InfoRecord, S extends InfoRecord> {
	
	public boolean pruneRecord(T baseInfo, S selectedInfo);
	public boolean shouldPrune(T baseInfo, S selectedInfo);
}
