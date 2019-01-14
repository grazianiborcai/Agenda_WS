package br.com.gda.info;

public interface InfoKeeperVisitor<T,S> {
	public T keepAtribute(T sourceOne, S sourceTwo);
	
	public boolean shouldWrite(T sourceOne, S sourceTwo);
}
