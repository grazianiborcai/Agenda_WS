package br.com.gda.info.obsolete;

public interface InfoKeeperVisitor_<T,S> {
	public T keepAtribute(T sourceOne, S sourceTwo);
	
	public boolean shouldWrite(T sourceOne, S sourceTwo);
}
