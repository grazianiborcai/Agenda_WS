package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface ActionVisitorV1<T extends InfoRecord> {
	public List<T> executeTransformation(List<T> recordInfos);
}
