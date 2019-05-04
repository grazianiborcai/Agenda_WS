package br.com.gda.model.action;

import java.util.List;

public interface ActionVisitorMerge<T> {
	public List<T> executeTransformation(List<T> recordInfos);
}
