package br.com.mind5.model.action;

import java.util.List;

public interface ActionVisitorPrune_<T> {
	public List<T> executeTransformation(List<T> recordInfos);
}