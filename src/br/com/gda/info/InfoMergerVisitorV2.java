package br.com.gda.info;

public interface InfoMergerVisitorV2<T,K> {
	public T writeRecord(K sourceOne, T sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, T sourceTwo);
}
