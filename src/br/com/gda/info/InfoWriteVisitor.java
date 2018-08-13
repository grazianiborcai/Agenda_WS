package br.com.gda.info;

public interface InfoWriteVisitor<T,K,S> {
	public T writeRecord(K sourceOne, S sourceTwo);
}
