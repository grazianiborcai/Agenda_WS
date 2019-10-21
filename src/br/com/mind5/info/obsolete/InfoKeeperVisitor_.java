package br.com.mind5.info.obsolete;

public interface InfoKeeperVisitor_<T,S> {
	public T keepAtribute(T sourceOne, S sourceTwo);
	
	public boolean shouldWrite(T sourceOne, S sourceTwo);
}
