package br.com.mind5.model.action;

public interface ActionVisitorMap<T,S> {
	public S buildMapKey(T recordInfo);
}
