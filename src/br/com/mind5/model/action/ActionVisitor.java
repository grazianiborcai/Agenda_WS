package br.com.mind5.model.action;

import java.util.List;

public interface ActionVisitor<T> {
	public List<T> executeTransformation(List<T> recordInfos);
}
