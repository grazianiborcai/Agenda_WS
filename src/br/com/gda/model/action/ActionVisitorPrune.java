package br.com.gda.model.action;

import java.util.List;

public interface ActionVisitorPrune<T> {
	public List<T> executeTransformation(List<T> recordInfos);
}
