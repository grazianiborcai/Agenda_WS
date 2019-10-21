package br.com.mind5.info;

public interface InfoPrunerSelfVisitor<T> {
	
	public T pruneRecord(T source);
	public boolean shouldPrune(T source);
}
