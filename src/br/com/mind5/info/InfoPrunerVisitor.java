package br.com.mind5.info;

public interface InfoPrunerVisitor<T extends InfoRecord, S extends InfoRecord> {
	
	public boolean pruneRecord(T baseInfo, S selectedInfo);
	public boolean shouldPrune(T baseInfo, S selectedInfo);
}
