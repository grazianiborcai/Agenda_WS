package br.com.gda.model.action;

public interface ActionVisitorMap<T,S> {
	public S buildMapKey(T recordInfo);
}
