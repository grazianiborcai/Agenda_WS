package br.com.mind5.info.obsolete;

public interface InfoMergerVisitor_<T,K> {
	public T writeRecord(K sourceOne, T sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, T sourceTwo);
}
