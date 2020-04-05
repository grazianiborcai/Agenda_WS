package br.com.mind5.info;

public interface InfoSetter<T extends InfoRecord> {
	
	public T setAttr(T obj);
}
