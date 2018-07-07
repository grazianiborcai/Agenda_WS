package br.com.gda.info;

public interface VisitorMerger<T,K,S> {
	public T mergeRecord(K sourceOne, S sourceTwo);
}
