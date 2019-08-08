package br.com.gda.info;

public interface InfoMergerVisitor<T,K> {
	public T writeRecord(K sourceOne, T sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, T sourceTwo);
}
