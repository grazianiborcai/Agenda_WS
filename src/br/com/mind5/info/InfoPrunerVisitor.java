package br.com.mind5.info;

public interface InfoPrunerVisitor<T,S> {
	
	public T pruneRecord(T sourceOne, S sourceTwo);
	public boolean shouldPrune(T sourceOne, S sourceTwo);
}
