package br.com.mind5.info.obsolete;
//	TODO: remover o S e transforma-lo em T
public interface InfoMergerVisitor_<T,K,S> {
	public T writeRecord(K sourceOne, S sourceTwo);	
	
	public boolean shouldWrite(K sourceOne, S sourceTwo);
}
