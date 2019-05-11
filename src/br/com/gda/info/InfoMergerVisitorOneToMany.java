package br.com.gda.info;

import java.util.List;

public interface InfoMergerVisitorOneToMany<T,K> {
	public List<T> writeRecord(K sourceOne, T sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, T sourceTwo);
}
