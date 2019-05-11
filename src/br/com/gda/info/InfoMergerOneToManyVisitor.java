package br.com.gda.info;

import java.util.List;

public interface InfoMergerOneToManyVisitor<T,K> {
	public List<T> writeRecord(K sourceOne, T sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, T sourceTwo);
}
