package br.com.gda.info;

public interface InfoPrunerVisitor<T,S> {
	public T pruneRecord(T sourceOne, S sourceTwo);
}
