package br.com.gda.info;

public interface InfoMergerVisitor<T,K,S> {
	public T mergeRecord(K sourceOne, S sourceTwo);
}
