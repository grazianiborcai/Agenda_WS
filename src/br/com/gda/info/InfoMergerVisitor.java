package br.com.gda.info;

public interface InfoMergerVisitor<T,K,S> {
	public T writeRecord(K sourceOne, S sourceTwo);
}
