package br.com.mind5.info;

public interface InfoMergerVisitor<T,K> {
	public T writeRecord(K sourceOne, T sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, T sourceTwo);
}
