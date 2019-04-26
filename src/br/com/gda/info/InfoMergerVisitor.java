package br.com.gda.info;
//	TODO: remover o S e transforma-lo em T
public interface InfoMergerVisitor<T,K,S> {
	public T writeRecord(K sourceOne, S sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, S sourceTwo);
}
