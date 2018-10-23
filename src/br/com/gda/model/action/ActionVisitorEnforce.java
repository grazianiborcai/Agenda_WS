package br.com.gda.model.action;

import java.util.List;

public interface ActionVisitorEnforce<T> {
	public List<T> executeTransformation(List<T> recordInfos);
}
